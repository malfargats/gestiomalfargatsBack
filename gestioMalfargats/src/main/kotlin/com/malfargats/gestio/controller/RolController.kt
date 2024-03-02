package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.RolDTO
import com.malfargats.gestio.service.RolService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/rols")
@RestController
@Validated
class RolController(val rolService: RolService) {
    fun getAllRols():List<RolDTO> = rolService.getAllRols();
}