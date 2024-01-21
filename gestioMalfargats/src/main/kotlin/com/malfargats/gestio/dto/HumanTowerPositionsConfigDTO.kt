package com.malfargats.gestio.dto

import com.malfargats.gestio.entity.HumanTower
import com.malfargats.gestio.entity.Position
import jakarta.validation.constraints.NotBlank
data class HumanTowerPositionsConfigDTO (
        var id:Long?,
        @NotBlank(message = "HumanTowerPositionsConfigDTO.humanTowerId is mandatory")
        var humanTower:HumanTower,
        @NotBlank(message = "HumanTowerPositionsConfigDTO.position is mandatory")
        var position:Position,
        @NotBlank(message = "HumanTowerPositionsConfigDTO.offsetX is mandatory")
        var offsetX:Double,
        @NotBlank(message = "HumanTowerPositionsConfigDTO.offsetY is mandatory")
        var offsetY:Double,
        @NotBlank(message = "HumanTowerPositionsConfigDTO.rotation is mandatory")
        var rotation:Double
)

