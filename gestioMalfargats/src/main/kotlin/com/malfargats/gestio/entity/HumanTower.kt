package com.malfargats.gestio.entity

import jakarta.persistence.*

@Entity
@Table(name = "HumanTowers")
data class HumanTower(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        var name: String,
        var height: Int,
        var difficulty: Int,
        var humanTowerBuildersPerFloor: Int
)