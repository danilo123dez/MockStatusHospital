package com.mockstatushospital.MockStatusHospital.usecases;

import com.fasterxml.jackson.databind.JsonNode;
import com.mockstatushospital.MockStatusHospital.MockStatusHospitalApplication;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendInfoQueueHospital {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.send.info.queue}")
    private String topicName;

    private static Logger logger = LoggerFactory.getLogger(MockStatusHospitalApplication.class);

    public void messagingSendInfoQueueHospital(JsonNode jsonNode){
        logger.info("Enviando mensagem kafka...", jsonNode);
        kafkaTemplate.send(topicName, String.valueOf(jsonNode));
    }
}
