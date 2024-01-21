package com.malfargats.gestio.entity

import jakarta.persistence.*


@Entity
@Table(name="HumanTowerPositions")
data class Position(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long?,
        var name:String,
        var red:Int,
        var green:Int,
        var blue:Int
)