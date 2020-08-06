package com.example.demo.service;

import com.example.demo.entities.Mail;
import com.example.demo.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final MailRepository mailRepository;

    @Autowired
    public MailService(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public Boolean searchEmail(Mail mail) {
        if (mailRepository.findCountByMail(mail.getMail()) == 0) {
            save(mail);
            return false;
        }
        return true;
    }

    private void save(Mail mail) {
        mailRepository.save(mail);
    }

}
