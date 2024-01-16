package com.malfargats.gestio.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "Castells")
data class Castell(
        val id:Long?,
        val nom:String,
        val altura:Int,
        val dificultat:Int,
        val castellersPerPis:Int,
)