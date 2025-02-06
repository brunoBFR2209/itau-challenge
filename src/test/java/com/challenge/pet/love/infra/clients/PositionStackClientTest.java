package com.challenge.pet.love.infra.clients;

import com.challenge.pet.love.infra.dto.PositionStackLocationDTO;
import com.challenge.pet.love.infra.dto.PositionStackResponseDTO;
import com.challenge.pet.love.infra.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PositionStackClientTest {

    @InjectMocks
    private PositionStackClient positionStackClient;

    @Mock
    private RestTemplate restTemplate;

    private final String mockUrl = "http://api.positionstack.com/v1/reverse";
    private final String mockKey = "test";

    @Test
    void requestPositionSuccessfulResponseReturnsLocationList() {

        double latitude = 40.7128;
        double longitude = -74.0060;

        ReflectionTestUtils.setField(positionStackClient, "positionStackUrl", "http://api.positionstack.com/v1/reverse");
        ReflectionTestUtils.setField(positionStackClient, "apiKey", "test");
        PositionStackResponseDTO mockResponse = new PositionStackResponseDTO();
        PositionStackLocationDTO locationDTO = new PositionStackLocationDTO();
        List<PositionStackLocationDTO> mockData = Collections.singletonList(locationDTO);
        mockResponse.setData(mockData);
        String expectedUrl = UriComponentsBuilder.fromUriString(mockUrl)
                .queryParam("access_key", mockKey)
                .queryParam("query", String.valueOf(latitude) + "," + String.valueOf(longitude))
                .build().toUriString();

        when(restTemplate.exchange(
                expectedUrl,
                HttpMethod.GET,
                null,
                PositionStackResponseDTO.class
        )).thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

        List<PositionStackLocationDTO> result = positionStackClient.requestPosition(latitude, longitude);

        assertEquals(1, result.size());
        assertEquals(locationDTO, result.get(0));
    }

    @Test
    void requestPositionUnsuccessfulResponseThrowsBusinessException() {
        double latitude = 40.7128;
        double longitude = -74.0060;
        ReflectionTestUtils.setField(positionStackClient, "positionStackUrl", "http://api.positionstack.com/v1/reverse");
        ReflectionTestUtils.setField(positionStackClient, "apiKey", "test");
        String expectedUrl = UriComponentsBuilder.fromUriString(mockUrl)
                .queryParam("access_key", mockKey)
                .queryParam("query", String.valueOf(latitude) + "," + String.valueOf(longitude))
                .build().toUriString();

        when(restTemplate.exchange(
                expectedUrl,
                HttpMethod.GET,
                null,
                PositionStackResponseDTO.class
        )).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));


        assertThrows(BusinessException.class, () -> positionStackClient.requestPosition(latitude, longitude));
    }

    @Test
    void requestPositionExceptionThrownByRestTemplateThrowsBusinessException() {
        double latitude = 40.7128;
        double longitude = -74.0060;
        ReflectionTestUtils.setField(positionStackClient, "positionStackUrl", "http://api.positionstack.com/v1/reverse");
        ReflectionTestUtils.setField(positionStackClient, "apiKey", "test");

        String expectedUrl = UriComponentsBuilder.fromUriString(mockUrl)
                .queryParam("access_key", mockKey)
                .queryParam("query", String.valueOf(latitude) + "," + String.valueOf(longitude))
                .build().toUriString();


        when(restTemplate.exchange(
                expectedUrl,
                HttpMethod.GET,
                null,
                PositionStackResponseDTO.class
        )).thenThrow(new RuntimeException("RestTemplate Exception"));

        assertThrows(BusinessException.class, () -> positionStackClient.requestPosition(latitude, longitude));
    }
}
