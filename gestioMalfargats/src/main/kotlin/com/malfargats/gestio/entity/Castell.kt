package com.malfargats.gestio.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Castells")
data class Castell(
        @Id
        val id:Long,
        val nom:String,
        val altura:Int,
        val dificultat:Int,
        val castellersPerPis:Int,
)