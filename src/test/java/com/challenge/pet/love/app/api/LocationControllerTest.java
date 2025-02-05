package com.challenge.pet.love.app.api;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.app.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocationControllerTest {

    @InjectMocks
    private LocationController locationController;

    @Mock
    private LocationService locationService;

    @Test
    void findPetLocation_withLocation_returnsOk() {
        double latitude = 10.0;
        double longitude = 20.0;
        LocationResponseDTO locationResponseDTO = loadMock();
        when(locationService.findPetLocation(latitude, longitude)).thenReturn(Optional.of(locationResponseDTO));

        ResponseEntity<LocationResponseDTO> response = locationController.findPetLocation(null, latitude, longitude, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(locationResponseDTO, response.getBody());
    }

    @Test
    void findPetLocation_noLocation_returnsNoContent() {
        double latitude = 10.0;
        double longitude = 20.0;
        when(locationService.findPetLocation(latitude, longitude)).thenReturn(Optional.empty());

        ResponseEntity<LocationResponseDTO> response = locationController.findPetLocation(null, latitude, longitude, null);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void findPetLocation_withSensorId_shouldNotAffectResult() {

        double latitude = 10.0;
        double longitude = 20.0;
        String sensorId = "123"; // Example sensor ID
        LocationResponseDTO locationResponseDTO = loadMock();
        when(locationService.findPetLocation(latitude, longitude)).thenReturn(Optional.of(locationResponseDTO));

        ResponseEntity<LocationResponseDTO> response = locationController.findPetLocation(sensorId, latitude, longitude, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(locationResponseDTO, response.getBody());
    }


    @Test
    void findPetLocation_withDateTime_shouldNotAffectResult() {
        double latitude = 10.0;
        double longitude = 20.0;
        LocalDateTime dateTime = LocalDateTime.now(); // Example date and time
        LocationResponseDTO locationResponseDTO = loadMock();
        when(locationService.findPetLocation(latitude, longitude)).thenReturn(Optional.of(locationResponseDTO));

        ResponseEntity<LocationResponseDTO> response = locationController.findPetLocation(null, latitude, longitude, dateTime);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(locationResponseDTO, response.getBody());
    }

    public LocationResponseDTO loadMock(){
        return LocationResponseDTO.builder().build();
    }
}

