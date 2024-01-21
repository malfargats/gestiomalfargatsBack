package com.malfargats.gestio.entity

import jakarta.persistence.*

@Entity
@Table(name = "HumanTowers")
data class HumanTower(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,
        var name: String,
        var height: Int,
        var difficulty: Int,
        var humanTowerBuildersPerFloor: Int,
        @OneToMany(targetEntity = HumanTowerPositionsConfig::class,mappedBy = "humanTower", cascade = [CascadeType.ALL], orphanRemoval = true)
        var humanTowerPositionsConfig:  List<HumanTowerPositionsConfig>? = listOf()
)