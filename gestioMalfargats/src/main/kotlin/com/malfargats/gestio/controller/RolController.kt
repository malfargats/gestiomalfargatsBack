package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.RolDTO
import com.malfargats.gestio.service.RolService
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
class RolController(val rolService: RolService) {
    @GetMapping
    fun getAllRols():List<RolDTO> = rolService.getAllRols();
    @GetMapping("/{id}")
    fun getRolById(@PathVariable id:Long):RolDTO=rolService.getRolById(id);
    @PostMapping
    fun createRol(@RequestBody rolDTO: RolDTO):RolDTO=rolService.createRol(rolDTO);
    @PutMapping("/{id}")
    fun updateRol(@PathVariable id: Long,@RequestBody rolDTO: RolDTO) = rolService.updateRol(id,rolDTO);
    @DeleteMapping("/{id}")
    fun deleteRol(@PathVariable id:Long)=rolService.deleteRol(id);
}