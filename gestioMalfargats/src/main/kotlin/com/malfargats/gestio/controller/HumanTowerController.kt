package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.HumanTowerDTO
import com.malfargats.gestio.service.HumanTowerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/humantowers")
@Validated
class HumanTowerController(val humanTowerService: HumanTowerService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createHumanTowers(@RequestBody @Valid humanTowerlDto:HumanTowerDTO):HumanTowerDTO{
        return humanTowerService.createHumanTower(humanTowerlDto);

    }
    @GetMapping
    fun getAllHumanTowers():List<HumanTowerDTO>{
        return humanTowerService.getAllHumanTowers();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateHumanTower(@RequestBody @Valid humanTowerlDto: HumanTowerDTO,@PathVariable("id") id:Long):HumanTowerDTO{
        return humanTowerService.updateHumanTower(humanTowerlDto,id);
    }
    @GetMapping("/{id}")
    fun getHumanTower(@PathVariable("id") id: Long):HumanTowerDTO {
        return humanTowerService.getHumanTower(id);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deleteHumanTower(@PathVariable("id")id: Long){
        return humanTowerService.deleteHumanTower(id);
    }
}