package com.challenge.pet.love.domain;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.domain.useCase.impl.LocationUseCaseImpl;
import com.challenge.pet.love.infra.dataProvider.PositionStackDataProvider;
import com.challenge.pet.love.infra.exception.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocationUseCaseImplTest {

    @InjectMocks
    private LocationUseCaseImpl locationUseCase;

    @Mock
    private PositionStackDataProvider positionStackDataProvider;

    @Test
    void findLocationLocationFoundReturnsLocationResponseDTO() {
        double latitude = 10.0;
        double longitude = 20.0;
        LocationResponseDTO expectedLocation = new LocationResponseDTO();

        when(positionStackDataProvider.findLocation(latitude, longitude)).thenReturn(expectedLocation);

        LocationResponseDTO actualLocation = locationUseCase.findLocation(latitude, longitude);

        assertEquals(expectedLocation, actualLocation);
        verify(positionStackDataProvider, times(1)).findLocation(10.0, 20.0);
    }

    @Test
    void findLocationExceptionThrownReturnsNull() {
        double latitude = 10.0;
        double longitude = 20.0;

        when(positionStackDataProvider.findLocation(latitude, longitude)).thenThrow(new BusinessException("Simulated Exception"));

        Assertions.assertThrows(BusinessException.class, () -> {
          locationUseCase.findLocation(latitude, longitude);

            verify(positionStackDataProvider, times(1)).findLocation(10.0, 20.0);

        });
         }
}