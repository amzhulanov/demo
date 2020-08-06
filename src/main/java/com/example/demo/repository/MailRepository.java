package com.example.demo.repository;

import com.example.demo.entities.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    @Query("Select Count(mail) FROM Mail where mail=?1")
    Integer findCountByMail(String mail);

}
