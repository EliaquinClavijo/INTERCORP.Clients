package com.intercorp.clients.business.impl;

import com.intercorp.clients.business.IClientService;
import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import com.intercorp.clients.repository.ClientRepository;
import com.intercorp.clients.util.mapper.ClientMapper;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
