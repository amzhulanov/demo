package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @javax.validation.constraints.Email
    @NotNull
    private String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
}
