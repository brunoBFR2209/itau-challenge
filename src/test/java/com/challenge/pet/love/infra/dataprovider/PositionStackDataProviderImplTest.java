package com.challenge.pet.love.infra.dataprovider;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.infra.clients.PositionStackClient;
import com.challenge.pet.love.infra.dataProvider.impl.PositionStackDataProviderImpl;
import com.challenge.pet.love.infra.dto.PositionStackLocationDTO;
import com.challenge.pet.love.infra.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PositionStackDataProviderImplTest {

    @InjectMocks
    private PositionStackDataProviderImpl dataProvider;

    @Mock
    private PositionStackClient positionStackClient;

    @Test
    void findLocationAddressFoundReturnsLocationResponseDTO() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        PositionStackLocationDTO positionStackLocationDTO = loadMock();

        List<PositionStackLocationDTO> locationList = Collections.singletonList(positionStackLocationDTO);

        when(positionStackClient.requestPosition(latitude, longitude)).thenReturn(locationList);

        LocationResponseDTO result = dataProvider.findLocation(latitude, longitude);

        assertEquals("123 Main St", result.getAddress());
        assertEquals("New York", result.getState());
        assertEquals("USA", result.getCountry());
        assertEquals("Midtown", result.getNeighborhood());
        assertEquals("New York City", result.getCity());
    }

    @Test
    void findLocationNoAddressFoundThrowsBusinessException() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        PositionStackLocationDTO positionStackLocationDTO = PositionStackLocationDTO.builder()
                .type("att")
                .build();

        List<PositionStackLocationDTO> locationList = Collections.singletonList(positionStackLocationDTO);

        when(positionStackClient.requestPosition(latitude, longitude)).thenReturn(locationList);

        assertThrows(BusinessException.class, () -> dataProvider.findLocation(latitude, longitude));
    }

    @Test
    void findLocationEmptyListThrowsBusinessException() {
        double latitude = 40.7128;
        double longitude = -74.0060;
        List<PositionStackLocationDTO> locationList = Collections.emptyList();

        when(positionStackClient.requestPosition(latitude, longitude)).thenReturn(locationList);

        assertThrows(BusinessException.class, () -> dataProvider.findLocation(latitude, longitude));
    }


    @Test
    void findLocationExceptionFromClientThrowsBusinessException() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        when(positionStackClient.requestPosition(latitude, longitude)).thenThrow(new BusinessException("Simulated exception"));

        assertThrows(BusinessException.class, () -> dataProvider.findLocation(latitude, longitude));
    }


    @Test
    void findLocationNullListThrowsBusinessException() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        when(positionStackClient.requestPosition(latitude, longitude)).thenReturn(new ArrayList<>());

        assertThrows(BusinessException.class, () -> dataProvider.findLocation(latitude, longitude));
    }

    private PositionStackLocationDTO loadMock(){

        return PositionStackLocationDTO.builder()
                .type("address")
                .street("123 Main St")
                .region("New York")
                .country("USA")
                .neighbourhood("Midtown")
                .locality("New York City")
                .build();
    }
}