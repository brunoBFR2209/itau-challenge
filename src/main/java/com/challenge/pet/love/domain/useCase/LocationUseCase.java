package com.challenge.pet.love.domain.useCase;

import com.challenge.pet.love.app.dto.LocationResponseDTO;

public interface LocationUseCase {
    LocationResponseDTO findLocation(double latitude, double longitude);
}
