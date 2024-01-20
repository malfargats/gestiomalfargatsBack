package com.malfargats.gestio.dto

data class HumanTowerDTO (
        val id: Long?,
        var name: String,
        var height: Int,
        var difficulty: Int,
        var humanTowerBuildersPerFloor: Int
)