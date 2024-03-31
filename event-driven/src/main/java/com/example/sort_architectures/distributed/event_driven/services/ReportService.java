package com.example.sort_architectures.distributed.event_driven.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@KafkaListener(topics = "${topic.name.topic-report}", groupId = "{topic.groupId}")
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private PrintWriter out;

    @PostConstruct
    public void init() {
        final var reportFile = new File("report/report.txt");
        try {
            final var existed = reportFile.createNewFile();
            if (!existed) {
                log.info("File report already existed");
            }
            out = new PrintWriter(reportFile);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaHandler
    public void generateReport(final String report) {
        out.println("Report: " + report);
        out.flush();
    }
}




