package com.malfargats.gestio.entity

import com.malfargats.gestio.dto.CastleDTO
import jakarta.persistence.*

@Entity
@Table(name = "Castle")
data class Castle(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String,
        var description: String,
        @OneToMany(mappedBy = "castle", cascade = [CascadeType.ALL], orphanRemoval = true)
        val positions: List<Position> = mutableListOf()
){
}