package com.intercorp.clients.business;

import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import com.intercorp.clients.model.dao.entity.dto.ClientRequestDto;
import com.intercorp.clients.model.dao.entity.dto.kpideclientesDto;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import reactor.core.publisher.Mono;

public interface IClientService {

    Observable<ClientDto> getAllClients();

    Mono<ClientRequestDto> saveClient(ClientRequestDto clientRequestDto);

    Maybe<kpideclientesDto> getKpicdeClientes();
}
