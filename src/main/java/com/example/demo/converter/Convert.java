package com.example.demo.converter;

import com.example.demo.dto.MailDto;
import com.example.demo.entities.Mail;
import com.example.demo.mapper.MailMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import static com.pivovarit.function.ThrowingSupplier.unchecked;

@Component
@Slf4j
public class Convert {

    private final ObjectMapper objectMapper;
    private final MailMapper mailMapper;

    public Convert(ObjectMapper objectMapper, MailMapper mailMapper) {
        this.objectMapper = objectMapper;
        this.mailMapper = mailMapper;
    }

    //toEntity
    public Mail toEntity(String json) {
        MailDto mailDto = toDTO(json);
        return mailMapper.toEntity(mailDto);
    }

    // toDTO
    private MailDto toDTO(String json) {
        return unchecked(() -> objectMapper.readValue(json, MailDto.class)).get();
    }

}
