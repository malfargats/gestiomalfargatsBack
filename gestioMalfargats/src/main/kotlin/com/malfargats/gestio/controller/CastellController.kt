package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.CastellDTO
import com.malfargats.gestio.entity.Castell
import com.malfargats.gestio.service.CastellService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/castells")
class CastellController(val castellService: CastellService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCastells(@RequestBody castellDto:CastellDTO):CastellDTO{
        return castellService.createCastell(castellDto);

    }
    @GetMapping
    fun getAllCastells():List<CastellDTO>{
        return castellService.getAllCastells();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCastell(@RequestBody castellDto: CastellDTO,@PathVariable("id") id:Long):CastellDTO{
        return castellService.updateCastell(castellDto,id);
    }
    @GetMapping("/{id}")
    fun getCastell(@PathVariable("id") id: Long):CastellDTO{
        return castellService.getCastell(id);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deleteCastell(@PathVariable("id")id: Long){
        return castellService.deleteCastell(id);
    }
}