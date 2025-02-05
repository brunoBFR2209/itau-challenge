package com.challenge.pet.love.app.service;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.app.service.imp.LocationServiceImpl;
import com.challenge.pet.love.domain.useCase.LocationUseCase;
import com.challenge.pet.love.infra.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocationServiceImplTest {

    @InjectMocks
    private LocationServiceImpl locationService;

    @Mock
    private LocationUseCase locationUseCase;

    @Test
    void findPetLocationLocationFoundReturnsOptionalWithLocation() {
        double latitude = 10.0;
        double longitude = 20.0;
        LocationResponseDTO locationResponseDTO = loadMock();

        when(locationUseCase.findLocation(latitude, longitude)).thenReturn(locationResponseDTO);

        Optional<LocationResponseDTO> result = locationService.findPetLocation(latitude, longitude);

        assertTrue(result.isPresent());
        assertEquals(locationResponseDTO, result.get());
        verify(locationUseCase, times(1)).findLocation(10.0, 20.0);
    }

    @Test
    void findPetLocationLocationNotFoundReturnsEmptyOptional() {
        double latitude = 10.0;
        double longitude = 20.0;

        when(locationUseCase.findLocation(latitude, longitude)).thenReturn(null);

        Optional<LocationResponseDTO> result = locationService.findPetLocation(latitude, longitude);

        assertTrue(result.isEmpty());
        verify(locationUseCase, times(1)).findLocation(10.0, 20.0);
    }


    @Test
    void findPetLocationExceptionThrownReturnsEmptyOptional() {
        double latitude = 10.0;
        double longitude = 20.0;

        when(locationUseCase.findLocation(10.0, 20.0)).thenThrow(new BusinessException("Simulated Exception"));
        assertThrows(BusinessException.class, () ->{
            locationService.findPetLocation(latitude, longitude);
            verify(locationUseCase, times(1)).findLocation(10.0, 20.0);
        });
    }

    public LocationResponseDTO loadMock(){
        return LocationResponseDTO.builder().build();
    }
}