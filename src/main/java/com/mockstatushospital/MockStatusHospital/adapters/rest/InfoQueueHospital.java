package com.mockstatushospital.MockStatusHospital.adapters.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mockstatushospital.MockStatusHospital.adapters.rest.facade.SendInfoQueueHospitalFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("info-queue-hospital")
public class InfoQueueHospital {

    @Autowired
    SendInfoQueueHospitalFacade sendInfoQueueHospitalFacade;

    @PutMapping("/{hospital}")
    public ResponseEntity<Void> updateQueueHospital(@PathVariable int hospital, @RequestBody String body) throws JsonProcessingException {
        sendInfoQueueHospitalFacade.messagingSendInfoQueueHospital(body, hospital);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
