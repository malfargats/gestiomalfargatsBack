package com.malfargats.gestio.service

import com.malfargats.gestio.entity.Castle
import com.malfargats.gestio.entity.Position
import com.malfargats.gestio.exceptions.CastleException
import com.malfargats.gestio.exceptions.PositionException
import com.malfargats.gestio.repository.PositionRepository

class PositionService(private val positionRepository: PositionRepository) {
    fun createPosition(position: Position): Position {
        return positionRepository.save(position)
    }
    fun getPositionById(id: Long): Position {
        return positionRepository.findById(id).orElseThrow { PositionException("Position not found by id $id") }

    }
    fun deletePosition(id: Long){
        positionRepository.deleteById(id);

    }

}