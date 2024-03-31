package com.example.sort_architectures.distributed.event_driven.controllers.core;

import com.example.sort_architectures.distributed.event_driven.messages.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrossBeltSorterController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.name.topic-cross-belt}")
    private String crossBeltTopicName;

    @GetMapping("/calibrate-sorter")
    public HttpStatus calibrateSorter() {
        kafkaTemplate.send(crossBeltTopicName, Messages.CALIBRATE_SORTER);
        return HttpStatus.OK;
    }

    @GetMapping("/optimize-sorter")
    public HttpStatus optimizeSorter() {
        kafkaTemplate.send(crossBeltTopicName, Messages.OPTIMIZE_SORTER);
        return HttpStatus.OK;
    }

    @GetMapping("/belt/status")
    public String getBeltStatus() {
        return "Belt is operational";
    }

    @PostMapping("/belt/quality-assurance")
    public HttpStatus performQualityAssurance(@RequestBody final String item) {
        kafkaTemplate.send(crossBeltTopicName, Messages.QUALITY_ASSURANCE + " " + item);
        return HttpStatus.OK;
    }
}
