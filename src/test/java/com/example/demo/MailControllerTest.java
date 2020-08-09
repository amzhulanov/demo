package com.example.demo;

import com.example.demo.entities.Mail;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MailControllerTest {

    @Autowired
    private MockMvc mvc;

    private String json;

    @BeforeEach
    public void setData() {
        json = new Gson().toJson(new Mail("cogito@ergo.sum"));
    }

    @Test
    void searchEmailTest() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .get("/service")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders
                .get("/service")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());

        mvc.perform(MockMvcRequestBuilders
                .get("/service")
                .contentType(MediaType.APPLICATION_JSON).content("mail.ru"))
                .andExpect(status().isBadRequest());
    }



}