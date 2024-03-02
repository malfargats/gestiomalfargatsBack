package com.malfargats.gestio.entity

import com.malfargats.gestio.dto.RolDTO
import jakarta.persistence.*


@Entity
@Table(name="Rol")
data class Rol(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long?=null,
        var name:String,

){
        fun toDTO():RolDTO{
                return RolDTO(id,name);
        }
}

