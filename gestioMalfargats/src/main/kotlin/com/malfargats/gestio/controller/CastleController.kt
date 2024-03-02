package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.CastleDTO
import com.malfargats.gestio.service.CastleService
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
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/castles")
@Validated
class CastleController(val castleService: CastleService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCastle(@RequestBody @Valid castleDto:CastleDTO):CastleDTO{
        return castleService.createCastle(castleDto);

    }
    @GetMapping
    fun getAllCastles():List<CastleDTO>{
        return castleService.getAllCastles();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCastle(@RequestBody @Valid humanTowerlDto: CastleDTO,@PathVariable("id") id:Long):CastleDTO{
        return castleService.updateCastle(humanTowerlDto,id);
    }
    @GetMapping("/{id}")
    fun getCastle(@PathVariable("id") id: Long):CastleDTO {
        return castleService.getCastle(id);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deleteCastle(@PathVariable("id")id: Long){
        return castleService.deleteCastle(id);
    }
}