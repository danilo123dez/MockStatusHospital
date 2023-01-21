package com.mockstatushospital.MockStatusHospital.adapters.rest.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockstatushospital.MockStatusHospital.usecases.SendInfoQueueHospital;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Async
@RequiredArgsConstructor
@Service
public class SendInfoQueueHospitalFacade {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SendInfoQueueHospital sendInfoQueueHospital;

    public void messagingSendInfoQueueHospital(String body) throws JsonProcessingException {
        JsonNode jsonBody = objectMapper.readTree(body);
        sendInfoQueueHospital.messagingSendInfoQueueHospital(jsonBody);
    }
}
