package com.intercorp.clients.business.impl;

import com.intercorp.clients.business.IClientService;
import com.intercorp.clients.model.dao.ClientDao;
import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import com.intercorp.clients.model.dao.entity.dto.ClientRequestDto;
import com.intercorp.clients.model.dao.entity.dto.kpideclientesDto;
import com.intercorp.clients.repository.ClientRepository;
import com.intercorp.clients.util.mapper.ClientMapper;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class ClientServiceImpl implements IClientService {

    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Observable<ClientDto> getAllClients() {
        return clientRepository.getAllActiveClients().map(client -> clientMapper.parseClient(client));
    }

    @Override
    public Mono<ClientRequestDto> saveClient(ClientRequestDto clientRequestDto) {
        return clientRepository.save(new ClientDao()
                .name(clientRequestDto.getName())
                .lastName(clientRequestDto.getLastName())
                .age(clientRequestDto.getAge())
                .birthdate(clientRequestDto.getBirthdate())).map(response -> clientRequestDto);
    }

    @Override
    public Maybe<kpideclientesDto> getKpicdeClientes() {
        return clientRepository.getAllAges().toList().map(data -> clientMapper.generateKpicdeClientes(data)).toMaybe();
    }
}
