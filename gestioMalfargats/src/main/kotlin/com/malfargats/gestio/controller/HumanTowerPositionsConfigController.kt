package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.HumanTowerPositionsConfigDTO
import com.malfargats.gestio.service.HumanTowerPositionsConfigService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/positions/config/humantower")
@Validated
class HumanTowerPositionsConfigController(val humanTowerPositionsConfigService : HumanTowerPositionsConfigService) {
    @GetMapping("/{humantower_id}")
    fun getAllHumanTowerPositionsConfigById(@PathVariable("humantower_id") humanTowerId:Long):List<HumanTowerPositionsConfigDTO>
    =  humanTowerPositionsConfigService.getAllHumanTowerPositionsConfigById(humanTowerId)
    @PostMapping
    fun createHumanTowerPositionsConfig(@RequestBody humanTowerPositionsConfigDTO: HumanTowerPositionsConfigDTO)=humanTowerPositionsConfigService.createHumanTowerPositionsConfig(humanTowerPositionsConfigDTO)
}