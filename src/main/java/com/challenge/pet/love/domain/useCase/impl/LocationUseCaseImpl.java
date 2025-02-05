package com.challenge.pet.love.domain.useCase.impl;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.domain.useCase.LocationUseCase;
import com.challenge.pet.love.infra.dataProvider.PositionStackDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationUseCaseImpl  implements LocationUseCase {

    @Autowired PositionStackDataProvider positionStackDataProvider;

    @Override
    public LocationResponseDTO findLocation(double latitude, double longitude){

        return positionStackDataProvider.findLocation(latitude, longitude);
    }
}
