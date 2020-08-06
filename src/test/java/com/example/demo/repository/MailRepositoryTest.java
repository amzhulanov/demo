package com.example.demo.repository;

import com.example.demo.entities.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MailRepositoryTest {

    private MailRepository mailRepository;

    @Autowired
    MailRepositoryTest(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @BeforeEach
    void setData() {
        mailRepository.save(new Mail("1@1.ru"));
    }

    @Test
    void findCountByEmail() {
        assertThat(mailRepository.findCountByMail("")).isEqualTo(0);
        assertThat(mailRepository.findCountByMail("1@1.ru")).isEqualTo(1);

    }
}