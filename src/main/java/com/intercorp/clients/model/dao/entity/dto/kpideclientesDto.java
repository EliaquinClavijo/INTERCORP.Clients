package com.intercorp.clients.model.dao.entity.dto;

import com.intercorp.clients.model.dao.ClientDao;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class kpideclientesDto {

    private Double average;

    private Double standardDeviation;

    public kpideclientesDto average(Double average) {
        this.average = average;
        return this;
    }

    public kpideclientesDto standardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
        return this;
    }
}
