package com.malfargats.gestio.entity

import com.malfargats.gestio.dto.CastleDTO
import jakarta.persistence.*

@Entity
@Table(name = "Castle")
data class Castle(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,
        var name: String,
        var description: String
){
        fun toDTO():CastleDTO{
                return CastleDTO(this.id,this.name,this.description)

        }
}