package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.HumanTowerPositionDTO
import com.malfargats.gestio.service.HumanTowerPositionService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/humantowers/positions")
@RestController
@Validated
class HumanTowerPositionController(val humanTowerPositionService: HumanTowerPositionService) {
    fun getAllHumanTowersPositions():List<HumanTowerPositionDTO> = humanTowerPositionService.getAllHumanTowerPositions();
}