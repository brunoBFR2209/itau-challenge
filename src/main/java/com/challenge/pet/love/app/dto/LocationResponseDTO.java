package com.challenge.pet.love.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponseDTO {

    private String country;
    private String state;
    private String neighborhood;
    private String address;
    private String city;
}
