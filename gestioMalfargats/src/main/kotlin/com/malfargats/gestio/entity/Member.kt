package com.malfargats.gestio.entity

import jakarta.persistence.*

@Entity
@Table(name = "Member")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val name:String,
    val age:Int,
    val weight:Double,
    val height:Double
)