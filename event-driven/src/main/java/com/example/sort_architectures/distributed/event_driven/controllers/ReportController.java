package com.example.sort_architectures.distributed.event_driven.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.name.topic-report}")
    private String reportTopicName;

    @GetMapping("/reports/{reportId}")
    public HttpStatus generateReport(@PathVariable final String reportId) {
        kafkaTemplate.send(reportTopicName, reportId);
        return HttpStatus.OK;
    }
}
