package com.intercorp.clients.model.dao.entity.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ClientRequestDto {

    private String name;

    private String lastName;

    private int age;

    private LocalDate birthdate;

}
