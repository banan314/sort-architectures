package com.example.sort_architectures.distributed.event_driven.kafka;

import com.example.sort_architectures.distributed.event_driven.events.BeltEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;
import java.util.UUID;

@EnableKafka
@Configuration
public class ConsumerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value("${topic.groupId}")
    private String beltGroupId;

    @Bean
    @ConditionalOnMissingBean
    public ConcurrentKafkaListenerContainerFactory<String, BeltEvent> checkKafkaListenerContainerFactory() {
        return kafkaListenerContainerFactory(beltGroupId);
    }

    @Bean
    public KafkaConsumer<String, BeltEvent> kafkaConsumer() {
        return new KafkaConsumer<>(consumerFactory(beltGroupId).getConfigurationProperties());
    }

    @Bean
    public KafkaConsumer<String, String> kafkaStringConsumer() {
        return new KafkaConsumer<>(consumerFactory(beltGroupId).getConfigurationProperties());
    }

    private ConcurrentKafkaListenerContainerFactory<String, BeltEvent> kafkaListenerContainerFactory(final String groupId) {
        final ConcurrentKafkaListenerContainerFactory<String, BeltEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(groupId));
        return factory;
    }

    private ConsumerFactory<String, BeltEvent> consumerFactory(final String groupId) {
        return new DefaultKafkaConsumerFactory<>(Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress,
                ConsumerConfig.GROUP_ID_CONFIG, groupId,
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 1000,
                ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10000,
                ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, ("SchedulerCoordinator-" + UUID.randomUUID()))
        );
    }
}
