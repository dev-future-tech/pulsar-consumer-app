package com.example.pulsarconsumerapp;

import com.example.model.TestMessage;
import org.apache.pulsar.common.schema.SchemaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Component;

@Component
public class PulsarMessageListener {

    private final Logger log = LoggerFactory.getLogger(PulsarMessageListener.class);

    @PulsarListener(subscriptionName = "hello-pulsar-subscription", topics = "persistent://public/test-namespace/hello-pulsar", schemaType = SchemaType.AVRO)
    public void listen(TestMessage message) {
        log.info("Message is id: {}, msg: {}", message.getMessageId(), message.getMessage());
    }

}
