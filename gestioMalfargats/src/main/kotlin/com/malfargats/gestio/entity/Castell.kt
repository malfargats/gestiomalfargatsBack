package com.malfargats.gestio.entity

import jakarta.persistence.*

@Entity
@Table(name = "Castells")
data class Castell(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long?,
        var nom:String,
        var altura:Int,
        var dificultat:Int,
        var castellersPerPis:Int,
)