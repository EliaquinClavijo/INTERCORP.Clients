package com.intercorp.clients.model.dao;

import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Table("client")
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
    private LocalDate birthdate;

    public ClientDao name(String name) {
        this.name = name;
        return this;
    }

    public ClientDao lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientDao age(int age) {
        this.age = age;
        return this;
    }

    public ClientDao birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

}
