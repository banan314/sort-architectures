package com.example.sort_architectures.distributed.event_driven.services;

import com.example.sort_architectures.distributed.event_driven.messages.Messages;
import com.example.sort_architectures.distributed.event_driven.messages.Messages.ReportMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@KafkaListener(topics = "${topic.name.topic-cross-belt}", groupId = "{topic.groupId}")
public class CrossBeltSorterService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.name.topic-belt}")
    private String beltTopicName;
    @Value("${topic.name.topic-report}")
    private String reportTopicName;

    @KafkaHandler
    public void listen(final String message) {
        final String command = message.split(" ")[0];

        switch (command) {
            case Messages.CALIBRATE_SORTER:
                calibrateSorter();
                break;
            case Messages.OPTIMIZE_SORTER:
                optimizeSorter();
                break;
            case Messages.QUALITY_ASSURANCE:
                performQualityAssurance(message.split(" ")[1]);
                break;
            default:
                break;
        }
    }

    private void calibrateSorter() {
        kafkaTemplate.send(beltTopicName, Messages.START_SORTER);
        kafkaTemplate.send(beltTopicName, Messages.STOP_SORTER);
    }

    private void optimizeSorter() {
        kafkaTemplate.send(beltTopicName, Messages.START_SORTER);
        kafkaTemplate.send(beltTopicName, Messages.SORT_ITEMS);
        kafkaTemplate.send(beltTopicName, Messages.STOP_SORTER);
        kafkaTemplate.send(reportTopicName, ReportMessages.SORTER_OPTIMIZED);
    }

    public void performQualityAssurance(final String item) {
        kafkaTemplate.send(beltTopicName, Messages.START_SORTER);
        kafkaTemplate.send(beltTopicName, Messages.STOP_SORTER);
        kafkaTemplate.send(reportTopicName, ReportMessages.QUALITY_ASSURANCE + item);
    }
}
