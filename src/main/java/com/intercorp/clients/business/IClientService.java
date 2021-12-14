package com.intercorp.clients.business;

import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import io.reactivex.Observable;

public interface IClientService {

    Observable<ClientDto> getAllClients();
}
