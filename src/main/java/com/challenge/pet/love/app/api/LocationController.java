package com.challenge.pet.love.app.api;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.app.service.LocationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "Invalid Param"),
            @ApiResponse(responseCode = "422", description = "Invalid Location"),
            @ApiResponse(responseCode = "500", description = "Integration failed")
    })
    @GetMapping
    public ResponseEntity<LocationResponseDTO> findPetLocation(@RequestParam String sensorId,
                                                        @RequestParam double latitude,
                                                        @RequestParam double longitude,
                                                        @RequestParam LocalDateTime dateTime
                                                ) {

        return locationService.findPetLocation(latitude, longitude)
                .map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }
}