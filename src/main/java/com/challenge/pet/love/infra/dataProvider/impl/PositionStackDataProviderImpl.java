package com.challenge.pet.love.infra.dataProvider.impl;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.infra.clients.PositionStackClient;
import com.challenge.pet.love.infra.dataProvider.PositionStackDataProvider;
import com.challenge.pet.love.infra.dto.PositionStackLocationDTO;
import com.challenge.pet.love.infra.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionStackDataProviderImpl implements PositionStackDataProvider {

    @Autowired PositionStackClient positionStackClient;

    @Override
    public LocationResponseDTO findLocation(double latitude, double longitude) {

        PositionStackLocationDTO positionStackLocationDTO = positionStackClient.requestPosition(latitude, longitude).stream()
                .filter(res -> res.getType().equalsIgnoreCase("address"))
                .findFirst().orElseThrow(() -> new BusinessException("Location not found"));

        return LocationResponseDTO.builder()
                .address(positionStackLocationDTO.getStreet())
                .state(positionStackLocationDTO.getRegion())
                .country(positionStackLocationDTO.getCountry())
                .neighborhood(positionStackLocationDTO.getNeighbourhood())
                .city(positionStackLocationDTO.getLocality())
                .build();
    }
}