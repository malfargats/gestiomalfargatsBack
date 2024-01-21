package com.malfargats.gestio.repository
import com.malfargats.gestio.entity.HumanTowerPosition
import org.springframework.data.repository.CrudRepository

interface HumanTowerPositionRepository: CrudRepository<HumanTowerPosition,Long> {
    fun findByNameContaining(name:String):List<HumanTowerPosition>;
}