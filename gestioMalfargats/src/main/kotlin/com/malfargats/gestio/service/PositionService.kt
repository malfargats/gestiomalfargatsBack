package com.malfargats.gestio.service
import com.malfargats.gestio.dto.PositionDTO
import com.malfargats.gestio.repository.PositionRepository
import org.springframework.stereotype.Service

@Service
class PositionService(val positionRepository: PositionRepository) {
    fun getAllPositions() : List<PositionDTO>{
        return positionRepository.findAll().map {
            it-> PositionDTO(id = it.id,name=it.name, red = it.red, green = it.green, blue = it.blue)
        }
    }
}