package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.RolDTO
import com.malfargats.gestio.mapper.RolMapper
import com.malfargats.gestio.service.RolService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/rols")
@RestController
@Validated
class RolController(val rolMapper: RolMapper) {
    @GetMapping
    fun getAllRols():ResponseEntity<List<RolDTO>> {
        val rols=rolMapper.getAllRols()
        return ResponseEntity.ok().body(rols);
    };
    @GetMapping("/{id}")
    fun getRolById(@PathVariable id:Long):ResponseEntity<RolDTO> {
        val rol =rolMapper.getRolById(id);
        return ResponseEntity.ok().body(rol);
    }
    @PostMapping
    fun createRol(@RequestBody rolDTO: RolDTO):ResponseEntity<RolDTO> {
        val createdRol=rolMapper.createRol(rolDTO);
        return ResponseEntity.ok().body(createdRol);
    }
    @PutMapping("/{id}")
    fun updateRol(@PathVariable id: Long,@RequestBody rolDTO: RolDTO):ResponseEntity<RolDTO>{
        val updatedRol=rolMapper.updateRol(id,rolDTO);
        return ResponseEntity.ok().body(updatedRol);
    }
    @DeleteMapping("/{id}")
    fun deleteRol(@PathVariable id:Long):ResponseEntity<Void> {
        rolMapper.deleteRol(id)
        return ResponseEntity.noContent().build()
    };
}