package com.example.sort_architectures.distributed.event_driven.controllers;

import com.example.sort_architectures.distributed.event_driven.entities.BeltItem;
import com.example.sort_architectures.distributed.event_driven.messages.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BeltController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.name.topic-belt}")
    private String beltTopicName;

    @GetMapping("/start-sorter")
    public HttpStatus startSorter() {
        kafkaTemplate.send(beltTopicName, Messages.START_SORTER);
        return HttpStatus.OK;
    }

    @GetMapping("/stop-sorter")
    public HttpStatus stopSorter() {
        kafkaTemplate.send(beltTopicName, Messages.STOP_SORTER);
        return HttpStatus.OK;
    }

    @PostMapping("/belt/items")
    public HttpStatus placeItem(@RequestBody final BeltItem item) {
        kafkaTemplate.send(beltTopicName, Messages.PLACE_ITEM + " " + item.toString());
        return HttpStatus.OK;
    }

    @DeleteMapping("/belt/items")
    public HttpStatus popItem() {
        kafkaTemplate.send(beltTopicName, Messages.POP_ITEM);
        return HttpStatus.OK;
    }

    @PostMapping("/belt/items/sort")
    public HttpStatus sortItems() {
        kafkaTemplate.send(beltTopicName, Messages.SORT_ITEMS);
        return HttpStatus.OK;
    }
}
