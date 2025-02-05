package com.challenge.pet.love.app.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LocationResponseDTOTest {

    @Test
    void testLocationResponseDTOBuilder() {
        String country = "United States";
        String state = "New York";
        String neighborhood = "Midtown";
        String address = "123 Main St";
        String city = "New York City";

        LocationResponseDTO locationResponseDTO = LocationResponseDTO.builder()
                .country(country)
                .state(state)
                .neighborhood(neighborhood)
                .address(address)
                .city(city)
                .build();

        assertEquals(country, locationResponseDTO.getCountry());
        assertEquals(state, locationResponseDTO.getState());
        assertEquals(neighborhood, locationResponseDTO.getNeighborhood());
        assertEquals(address, locationResponseDTO.getAddress());
        assertEquals(city, locationResponseDTO.getCity());
    }

    @Test
    void testLocationResponseDTOSettersAndGetters() {
        LocationResponseDTO locationResponseDTO = new LocationResponseDTO();

        locationResponseDTO.setCountry("Canada");
        locationResponseDTO.setState("Ontario");
        locationResponseDTO.setNeighborhood("Downtown");
        locationResponseDTO.setAddress("456 Elm St");
        locationResponseDTO.setCity("Toronto");

        assertEquals("Canada", locationResponseDTO.getCountry());
        assertEquals("Ontario", locationResponseDTO.getState());
        assertEquals("Downtown", locationResponseDTO.getNeighborhood());
        assertEquals("456 Elm St", locationResponseDTO.getAddress());
        assertEquals("Toronto", locationResponseDTO.getCity());
    }

    @Test
    void testLocationResponseDTONoArgsConstructor() {
        LocationResponseDTO locationResponseDTO = new LocationResponseDTO();
        assertNull(locationResponseDTO.getCountry());
        assertNull(locationResponseDTO.getState());
        assertNull(locationResponseDTO.getNeighborhood());
        assertNull(locationResponseDTO.getAddress());
        assertNull(locationResponseDTO.getCity());
    }

    @Test
    void testLocationResponseDTOAllArgsConstructor() {
        LocationResponseDTO locationResponseDTO = new LocationResponseDTO("USA",
                "NY", "Midtown", "123 5th Ave", "New York");
        assertEquals("USA", locationResponseDTO.getCountry());
        assertEquals("NY", locationResponseDTO.getState());
        assertEquals("Midtown", locationResponseDTO.getNeighborhood());
        assertEquals("123 5th Ave", locationResponseDTO.getAddress());
        assertEquals("New York", locationResponseDTO.getCity());
    }
}