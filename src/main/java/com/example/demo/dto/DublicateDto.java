package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DublicateDto {
    Boolean dublicate;

    public DublicateDto(Boolean dublicate) {
        this.dublicate = dublicate;
    }
}
