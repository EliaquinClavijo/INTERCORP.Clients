package com.intercorp.clients.model.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ClientDao implements Serializable {

    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("last_name")
    private String lastName;

    @Column("age")
    private int age;

    @Column("birthdate")
    private LocalDateTime birthdate;

}
