package com.intercorp.clients.model.dao.entity.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ClientDto {

    private String name;

    private String lastName;

    private int age;

    private LocalDateTime birthdate;

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

    public ClientDto birthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public ClientDto deadAge(int deadAge) {
        this.deadAge = deadAge;
        return this;
    }
}
