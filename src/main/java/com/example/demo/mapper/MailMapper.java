package com.example.demo.mapper;

import com.example.demo.dto.MailDto;
import com.example.demo.entities.Mail;
import org.mapstruct.Mapper;

@Mapper
public interface MailMapper {

    Mail toEntity(MailDto mailDto);

}
