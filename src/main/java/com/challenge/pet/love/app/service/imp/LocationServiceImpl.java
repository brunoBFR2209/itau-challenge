package com.challenge.pet.love.app.service.imp;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.app.service.LocationService;
import com.challenge.pet.love.domain.useCase.LocationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired LocationUseCase locationUseCase;

    @Override
    public Optional<LocationResponseDTO> findPetLocation(double latitude, double longitude){
        return Optional.ofNullable(locationUseCase.findLocation(latitude, longitude));
    }
}