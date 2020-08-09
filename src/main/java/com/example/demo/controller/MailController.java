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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public ResponseEntity<String> searchMail(@RequestBody String json) throws JsonProcessingException {
        if (checkEmail(json)) {
            Mail mail = convert.toEntity(json);
            if (mailService.searchMail(mail)) {
                return new ResponseEntity<>(objectMapper.writeValueAsString(new DublicateDto(true)), HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("The request must contain email", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean checkEmail(String json) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

}
