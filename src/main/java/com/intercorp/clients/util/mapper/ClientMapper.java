package com.intercorp.clients.util.mapper;

import com.intercorp.clients.model.dao.ClientDao;
import com.intercorp.clients.model.dao.entity.dto.ClientDto;
import com.intercorp.clients.model.dao.entity.dto.kpideclientesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@AllArgsConstructor
public class ClientMapper {

    public ClientDto parseClient(ClientDao client) {
        return new ClientDto()
                .name(client.getName())
                .lastName(client.getLastName())
                .age(client.getAge())
                .birthdate(client.getBirthdate())
                .deadAge(getRandomNumber(40, 100));
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public kpideclientesDto generateKpicdeClientes(List<Integer> data) {
        if (data.size() == 0) { return new kpideclientesDto().average((double) 0).standardDeviation( (double) 0);}
        Double average = round((data.stream().mapToDouble(a -> a).sum()/((double) data.size())), 2);
        if (data.size() == 1) { return new kpideclientesDto().average(average).standardDeviation( (double) 0);}
        double standardDeviation = Math.sqrt(round(((data.stream().mapToDouble(a -> Math.pow(a - average, 2))).sum()) / ((double) data.size()), 2));
        return new kpideclientesDto().average(average).standardDeviation(round(standardDeviation, 2));
    }
}
