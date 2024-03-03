package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.CastleDTO
import com.malfargats.gestio.mapper.CastleMapper
import com.malfargats.gestio.service.CastleService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
class CastleController(val castleMapper: CastleMapper) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCastle(@RequestBody @Valid castleDto:CastleDTO):ResponseEntity<CastleDTO>{
        val createdCastle=castleMapper.createCastle(castleDto);
        return ResponseEntity.ok().body(createdCastle);

    }
    @GetMapping
    fun getAllCastles():ResponseEntity<List<CastleDTO>>{
        val castles= castleMapper.getAllCastles();
        return ResponseEntity.ok().body(castles);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCastle(@RequestBody @Valid castleDto: CastleDTO,@PathVariable("id") id:Long):ResponseEntity<CastleDTO>{
        val updatedCastle = castleMapper.updateCastle(id,castleDto);
        return ResponseEntity.ok().body(updatedCastle);
    }
    @GetMapping("/{id}")
    fun getCastleById(@PathVariable("id") id: Long):ResponseEntity<CastleDTO> {
        val castle=castleMapper.getCastleById(id);
        return ResponseEntity.ok().body(castle);

    }
    @DeleteMapping("/{id}")
    fun deleteCastle(@PathVariable("id")id: Long):ResponseEntity<Void>{
        castleMapper.deleteCastle(id);
        return  ResponseEntity.noContent().build();
    }
}