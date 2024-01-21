package com.malfargats.gestio.repository
import com.malfargats.gestio.entity.Position
import org.springframework.data.repository.CrudRepository

interface PositionRepository: CrudRepository<Position,Long> {
    fun findByNameContaining(name:String):List<Position>;
}