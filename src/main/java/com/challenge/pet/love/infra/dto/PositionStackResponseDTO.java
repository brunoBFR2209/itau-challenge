package com.challenge.pet.love.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionStackResponseDTO {

    List<PositionStackLocationDTO> data;
}
