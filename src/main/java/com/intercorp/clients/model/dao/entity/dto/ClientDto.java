package com.intercorp.clients.model.dao.entity.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class ClientDto {

    private String name;

    private String lastName;

    private int age;

    private LocalDate birthdate;

    private int deadAge;

    public ClientDto name(String name) {
        this.name = name;
        return this;
    }

    public ClientDto lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientDto age(int age) {
        this.age = age;
        return this;
    }

    public ClientDto birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public ClientDto deadAge(int deadAge) {
        this.deadAge = deadAge;
        return this;
    }
}
