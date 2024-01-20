package com.malfargats.gestio.dto

import jakarta.validation.constraints.NotBlank

data class HumanTowerDTO (
        val id: Long?,
        @NotBlank(message = "HumanTowerDTO.name is mandatory")
        var name: String,
        @NotBlank(message = "HumanTowerDTO.height is mandatory")
        var height: Int,
        var difficulty: Int,
        @NotBlank(message = "HumanTowerDTO.humanTowerBuildersPerFloor is mandatory")
        var humanTowerBuildersPerFloor: Int
)