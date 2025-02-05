package com.challenge.pet.love.app.service;

import com.challenge.pet.love.app.dto.LocationResponseDTO;

import java.util.Optional;

public interface LocationService {
    Optional<LocationResponseDTO> findPetLocation(double latitude, double longitude);
}
