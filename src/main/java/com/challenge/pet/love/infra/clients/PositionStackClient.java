package com.challenge.pet.love.infra.clients;

import com.challenge.pet.love.infra.dto.PositionStackLocationDTO;
import com.challenge.pet.love.infra.dto.PositionStackResponseDTO;
import com.challenge.pet.love.infra.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@Component
public class PositionStackClient {

    @Value("${app.client.location}")
    private String positionStackUrl;

    @Value("${app.key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    public List<PositionStackLocationDTO> requestPosition(double latitude, double longitude) {
        try {
            ResponseEntity<PositionStackResponseDTO> response = restTemplate.exchange(
                    createURl(String.valueOf(latitude), String.valueOf(longitude))
                    , HttpMethod.GET,
                    null,
                    PositionStackResponseDTO.class
            );

            if (!response.getStatusCode().is2xxSuccessful() || !response.hasBody())
                throw new BusinessException("Error to integrate with positionStack");

            return response.getBody().getData();
        } catch ( Exception exception) {
            throw new BusinessException("Error to integrate with PositionStack");
        }
    }

    private String createURl(String latitude, String longitude) {

        return UriComponentsBuilder.fromUriString(positionStackUrl)
                .queryParam("access_key", apiKey)
                .queryParam("query", latitude.concat(",").concat(longitude)).build().toUriString();
    }
}
