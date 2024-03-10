package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.SvgDataDTO
import com.malfargats.gestio.service.SvgDataService
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/svgs")

class SvgDataController(private val svgDataService:SvgDataService) {
    @PostMapping
    fun createSvg(@RequestBody svgDataDTO: SvgDataDTO):ResponseEntity<Void>{
        svgDataService.createSvg(svgDataDTO)
        return ResponseEntity.noContent().build()

    }

}