package com.intercorp.clients.util.mapper;

import com.intercorp.clients.model.dao.ClientDao;
import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientMapper {

    public ClientDto parseClient(ClientDao client) {
        return new ClientDto()
                .name(client.getName())
                .lastName(client.getLastName())
                .age(client.getAge())
                .birthdate(client.getBirthdate())
                .deadAge(100);
    }
}
