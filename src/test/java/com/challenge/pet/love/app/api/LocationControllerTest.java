package com.challenge.pet.love.app.api;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.app.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(LocationController.class)
public class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @Test
    public void shouldReturnLocationSuccess() throws Exception {
        double latitude = 10.0;
        double longitude = 20.0;
        LocationResponseDTO locationResponseDTO = new LocationResponseDTO();

        Mockito.when(locationService.findPetLocation(latitude, longitude))
                .thenReturn(Optional.of(locationResponseDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/location")
                        .param("latitude", String.valueOf(latitude))
                        .param("longitude", String.valueOf(longitude))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void shouldReturnLocationNotFound() throws Exception {
        double latitude = 10.0;
        double longitude = 20.0;
        Mockito.when(locationService.findPetLocation(latitude, longitude))
                .thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/location")
                        .param("latitude", String.valueOf(latitude))
                        .param("longitude", String.valueOf(longitude))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    public void shouldReturnLocationBadRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/location")
                        .param("latitude", "abc")
                        .param("longitude", "20.0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/location")
                        .param("latitude", "10.0")
                        .param("longitude", "xyz")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldUseDataIdSensor() throws Exception {
        double latitude = 10.0;
        double longitude = 20.0;
        String sensorId = "sensor123";
        LocalDateTime dateTime = LocalDateTime.now();

        Mockito.when(locationService.findPetLocation(latitude, longitude))
                .thenReturn(Optional.of(new LocationResponseDTO()));

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/location")
                        .param("latitude", String.valueOf(latitude))
                        .param("longitude", String.valueOf(longitude))
                        .param("sensorId", sensorId)
                        .param("dateTime", dateTime.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}