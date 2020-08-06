package com.example.demo.controller;

import com.example.demo.converter.Convert;
import com.example.demo.dto.DublicateDto;
import com.example.demo.entities.Mail;
import com.example.demo.service.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/service")
@Slf4j
public class MailController {

    private final Convert convert;
    private final MailService mailService;
    private final ObjectMapper objectMapper;


    @Autowired
    public MailController(Convert convert, MailService mailService, ObjectMapper objectMapper) {
        this.convert = convert;
        this.mailService = mailService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<String> searchEmail(@RequestBody String json) throws JsonProcessingException {
        Mail mail = convert.toEntity(json);
        if (mailService.searchEmail(mail)) {
            return new ResponseEntity<>(objectMapper.writeValueAsString(new DublicateDto(true)), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("", HttpStatus.OK);
        }

    }


}
