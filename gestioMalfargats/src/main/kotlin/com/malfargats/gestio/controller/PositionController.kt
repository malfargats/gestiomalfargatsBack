package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.PositionDTO
import com.malfargats.gestio.service.PositionService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/positions")
@RestController
@Validated
class PositionController(val positionService: PositionService) {
    fun getAllPositions():List<PositionDTO> = positionService.getAllPositions();
}