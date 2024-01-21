package com.malfargats.gestio.dto

import jakarta.validation.constraints.NotBlank

data class PositionDTO (

        var id:Long?,
        @NotBlank(message = "HumanTowerPositionDTO.name is mandatory")
        var name:String,
        @NotBlank(message = "HumanTowerPositionDTO.red is mandatory")
        var red:Int,
        @NotBlank(message = "HumanTowerPositionDTO.green is mandatory")
        var green:Int,
        @NotBlank(message = "HumanTowerPositionDTO.blue is mandatory")
        var blue:Int
)

