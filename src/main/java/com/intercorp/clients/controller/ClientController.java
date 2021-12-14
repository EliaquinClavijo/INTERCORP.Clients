package com.intercorp.clients.controller;

import com.intercorp.clients.business.impl.ClientServiceImpl;
import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @Operation(summary = "Se lista todos los clientes + la fecha probable de cada uno")
    @GetMapping(value = "/listclientes")
    public Maybe<ResponseEntity<Observable<ClientDto>>> getAll() {
        return Maybe.just(new ResponseEntity<>(
                clientService.getAllClients(), HttpStatus.OK));
    }
}
