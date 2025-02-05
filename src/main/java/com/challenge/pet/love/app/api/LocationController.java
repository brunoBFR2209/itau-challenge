package com.challenge.pet.love.app.api;

import com.challenge.pet.love.app.dto.LocationResponseDTO;
import com.challenge.pet.love.app.service.LocationService;
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

    @GetMapping
    public ResponseEntity<LocationResponseDTO> findPetLocation(@RequestParam(required = false) String sensorId,
                                                        @RequestParam double latitude,
                                                        @RequestParam double longitude,
                                                        @RequestParam(required = false) LocalDateTime dateTime
                                                ) {

        return locationService.findPetLocation(latitude, longitude)
                .map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }
}
