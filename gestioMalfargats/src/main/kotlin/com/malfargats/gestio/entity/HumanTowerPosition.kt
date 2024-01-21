package com.malfargats.gestio.entity

import jakarta.persistence.*

@Entity
@Table(name="HumanTowerPositions")
data class HumanTowerPosition(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long?,
        var name:String
)