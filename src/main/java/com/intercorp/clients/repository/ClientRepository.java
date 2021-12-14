package com.intercorp.clients.repository;

import com.intercorp.clients.model.dao.ClientDao;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClientRepository extends ReactiveCrudRepository<ClientDao, Long> {

    @Query(value = "SELECT * from client")
    Observable<ClientDao> getAllActiveClients();

    @Query(value = "SELECT age from client")
    Observable<Integer> getAllAges();
}
