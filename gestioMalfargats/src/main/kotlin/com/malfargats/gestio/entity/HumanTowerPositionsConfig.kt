package com.malfargats.gestio.entity

import jakarta.persistence.*

@Entity
@Table(name="HumanTowerPositionsConfig")
data class HumanTowerPositionsConfig (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long?,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "humantower_id",nullable = false)
        var humanTower:HumanTower,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "humantowerposition_id", nullable = false)
        var position:Position,
        var offsetX:Double,
        var offsetY:Double,
        var rotation:Double


)