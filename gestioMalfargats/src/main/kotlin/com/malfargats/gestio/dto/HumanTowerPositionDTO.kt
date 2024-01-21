package com.malfargats.gestio.dto

import jakarta.validation.constraints.NotBlank

data class HumanTowerPositionDTO (

        var id:Long?,
        @NotBlank(message = "HumanTowerPositionDTO.name is mandatory")
        var name:String
)

