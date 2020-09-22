package com.kroger.samplemicroservice.samplemicroservice.controller;

import com.kroger.samplemicroservice.samplemicroservice.service.model.DemoService;
import com.kroger.samplemicroservice.samplemicroservice.service.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/demo/{arg}")
    public ResponseEntity<?> getResponse(@PathVariable String arg) {
        ResponseObject responseObject = demoService.getResponse(arg);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}

