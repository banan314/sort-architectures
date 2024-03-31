package com.example.sort_architectures.distributed.event_driven.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value("${topic.name.topic-belt}")
    private String beltTopicName;

    @Value("${topic.name.topic-cross-belt}")
    private String crossBeltTopicName;

    @Value("${topic.name.topic-report}")
    private String reportTopicName;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        final Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic beltTopic() {
        return new NewTopic(beltTopicName, 1, (short) 1);
    }

    @Bean
    public NewTopic crossBeltTopic() {
        return new NewTopic(crossBeltTopicName, 1, (short) 1);
    }

    @Bean
    public NewTopic reportTopic() {
        return new NewTopic(reportTopicName, 1, (short) 1);
    }
}
