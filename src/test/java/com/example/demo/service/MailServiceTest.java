package com.example.demo.service;

import com.example.demo.entities.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MailServiceTest {

    private final MailService mailService;

    @Autowired
    MailServiceTest(MailService mailService) {
        this.mailService = mailService;
    }


    @Test
    void searchEmail() {
        assertThat(mailService.searchMail(new Mail("1@1.ru"))).isFalse();
    }
}