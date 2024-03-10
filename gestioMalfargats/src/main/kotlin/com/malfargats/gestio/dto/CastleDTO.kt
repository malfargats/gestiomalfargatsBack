package com.malfargats.gestio.dto

import com.malfargats.gestio.entity.Castle
import jakarta.validation.constraints.NotBlank

data class CastleDTO (
        val id: Long?,
        @NotBlank(message = "CastleDTO.name is mandatory")
        var name: String,
        @NotBlank(message = "CastleDTO.height is mandatory")
        var description:String,
        val positions:List<PositionDTO> = mutableListOf()

){
       fun toCastle():Castle{
               return Castle(id=this.id,name=this.name, description = this.description)
       }
}