package com.example.sort_architectures.distributed.event_driven.services;

import com.example.sort_architectures.distributed.event_driven.dto.SortStatusDto;
import com.example.sort_architectures.distributed.event_driven.entities.BeltItem;
import com.example.sort_architectures.distributed.event_driven.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.event_driven.exceptions.ItemsSortingException;
import com.example.sort_architectures.distributed.event_driven.messages.Messages;
import com.example.sort_architectures.distributed.event_driven.repositories.BeltRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.random.RandomGenerator;

@Service
@RequiredArgsConstructor
@KafkaListener(topics = "${topic.name.topic-belt}", groupId = "{topic.groupId}")
public class BeltService {

    private static final double ERROR_RATE = 0.05;
    private static final RandomGenerator random = RandomGenerator.getDefault();
    private final List<BeltItem> beltItemList = new ArrayList<>();
    private final BeltRepository beltRepository;
    private final KafkaTemplate<String, String> kafkaTemplateString;
    private final KafkaTemplate<String, BeltItem> kafkaTemplateBeltItem;
    @Value("${topic.name.topic-report}")
    private String reportTopicName;


    @KafkaHandler
    public void listen(final String message) {
        final String command = message.split(" ")[0];

        switch (command) {
            case Messages.START_SORTER:
                startSorter();
                break;
            case Messages.STOP_SORTER:
                stopSorter();
                break;
            case Messages.POP_ITEM:
                try {
                    popItem();
                } catch (final ItemPopppingException e) {
                    kafkaTemplateString.send(reportTopicName, "Popping item failed. " + e.getMessage());
                }
                break;
            case Messages.PLACE_ITEM:
                final var item = message.split(" ")[1];
                placeItem(new BeltItem(item));
                break;
            case Messages.SORT_ITEMS:
                try {
                    sortItems();
                } catch (final ItemsSortingException e) {
                    kafkaTemplateString.send(reportTopicName, "Items sorting failed. " + e.getMessage());
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    private void startSorter() {
        kafkaTemplateString.send(reportTopicName, SortStatusDto.Status.STARTED.toString());
    }

    private void stopSorter() {
        kafkaTemplateString.send(reportTopicName, SortStatusDto.Status.STOPPED.toString());
    }

    private void popItem() throws ItemPopppingException {
        if (random.nextDouble() < ERROR_RATE) {
            throw new ItemPopppingException("Item not popped from the belt");
        }
        final var item = beltItemList.stream()
                .findFirst()
                .orElseThrow(() -> new ItemPopppingException("The sorter is empty"));
        beltItemList.remove(item);
        kafkaTemplateBeltItem.send(reportTopicName, item);
    }

    private void placeItem(BeltItem item) {
        item = beltRepository.save(item);
        beltItemList.add(item);
        kafkaTemplateBeltItem.send(reportTopicName, item);
    }

    private void sortItems() throws ItemsSortingException {
        if (random.nextDouble() < ERROR_RATE) {
            throw new ItemsSortingException("Item sorting failed.");
        }

        beltItemList.sort(Comparator.naturalOrder());

        kafkaTemplateString.send(reportTopicName, "Items sorted successfully");
    }
}

