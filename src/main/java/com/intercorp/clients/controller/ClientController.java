package com.intercorp.clients.controller;

import com.intercorp.clients.business.impl.ClientServiceImpl;
import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import com.intercorp.clients.model.dao.entity.dto.ClientRequestDto;
import com.intercorp.clients.model.dao.entity.dto.kpideclientesDto;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

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

    @Operation(summary = "Se muestra promedio edad clientes asi como desviacion estandar de los mismos")
    @GetMapping(value = "/kpideclientes")
    public Maybe<ResponseEntity<Maybe<kpideclientesDto>>> getKpicdeClientes() {
        return Maybe.just(new ResponseEntity<>(
                clientService.getKpicdeClientes(), HttpStatus.OK));
    }

    @Operation(summary = "Se crea un nuevo cliente")
    @PostMapping(value = "/creacliente")
    public Maybe<ResponseEntity<Mono<ClientRequestDto>>> newClient(@RequestBody @Valid ClientRequestDto clientRequestDto) {
        return Maybe.just(new ResponseEntity<>(
                clientService.saveClient(clientRequestDto), HttpStatus.OK));
    }
}
