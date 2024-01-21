package com.malfargats.gestio.service
import com.malfargats.gestio.dto.HumanTowerPositionDTO
import com.malfargats.gestio.repository.HumanTowerPositionRepository
import org.springframework.stereotype.Service

@Service
class HumanTowerPositionService(val humanTowerPositionRepository: HumanTowerPositionRepository) {
    fun getAllHumanTowerPositions() : List<HumanTowerPositionDTO>{
        return humanTowerPositionRepository.findAll().map {
            it-> HumanTowerPositionDTO(id = it.id,name=it.name)
        }
    }
}