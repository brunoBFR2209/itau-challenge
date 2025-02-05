package com.challenge.pet.love.infra.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PositionStackResponseDTOTest {

    @Test
    void testPositionStackResponseDTOWithData() {
        PositionStackLocationDTO location1 = new PositionStackLocationDTO();
        location1.setLatitude(40.7128);
        location1.setLongitude(-74.0060);

        PositionStackLocationDTO location2 = new PositionStackLocationDTO();
        location2.setLatitude(34.0522);
        location2.setLongitude(-118.2437);

        List<PositionStackLocationDTO> data = List.of(location1, location2);

        PositionStackResponseDTO response = new PositionStackResponseDTO();
        response.setData(data);

        assertNotNull(response.getData());
        assertEquals(2, response.getData().size());
        assertEquals(40.7128, response.getData().get(0).getLatitude());
        assertEquals(-74.0060, response.getData().get(0).getLongitude());
        assertEquals(34.0522, response.getData().get(1).getLatitude());
        assertEquals(-118.2437, response.getData().get(1).getLongitude());
    }

    @Test
    void testPositionStackResponseDTOEmptyData() {
        List<PositionStackLocationDTO> data = List.of(); // Empty list

        PositionStackResponseDTO response = new PositionStackResponseDTO();
        response.setData(data);

        assertNotNull(response.getData()); // Should not be null, but empty
        assertEquals(0, response.getData().size());
    }


    @Test
    void testPositionStackResponseDTONullData() {
        List<PositionStackLocationDTO> data = null;

        PositionStackResponseDTO response = new PositionStackResponseDTO();
        response.setData(data);

        assertNull(response.getData());
    }

    @Test
    void testPositionStackResponseDTONoArgsConstructor() {
        PositionStackResponseDTO dto = new PositionStackResponseDTO();
        assertNull(dto.getData());
    }


    @Test
    void testPositionStackResponseDTOAllArgsConstructor() {
        PositionStackLocationDTO location1 = new PositionStackLocationDTO();
        location1.setLatitude(40.7128);
        location1.setLongitude(-74.0060);

        PositionStackLocationDTO location2 = new PositionStackLocationDTO();
        location2.setLatitude(34.0522);
        location2.setLongitude(-118.2437);

        List<PositionStackLocationDTO> data = List.of(location1, location2);
        PositionStackResponseDTO response = new PositionStackResponseDTO(data);

        assertNotNull(response.getData());
        assertEquals(2, response.getData().size());
        assertEquals(40.7128, response.getData().get(0).getLatitude());
        assertEquals(-74.0060, response.getData().get(0).getLongitude());
        assertEquals(34.0522, response.getData().get(1).getLatitude());
        assertEquals(-118.2437, response.getData().get(1).getLongitude());
    }
}