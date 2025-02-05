package com.challenge.pet.love.infra.dataProvider;

import com.challenge.pet.love.app.dto.LocationResponseDTO;

public interface PositionStackDataProvider {

    LocationResponseDTO findLocation(double latitude, double longitude);
}
