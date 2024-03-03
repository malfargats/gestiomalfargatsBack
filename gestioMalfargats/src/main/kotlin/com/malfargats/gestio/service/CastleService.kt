package com.malfargats.gestio.service

import com.malfargats.gestio.dto.CastleDTO
import com.malfargats.gestio.entity.Castle
import com.malfargats.gestio.exceptions.CastleException
import com.malfargats.gestio.repository.CastleRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CastleService(val castleRepository: CastleRepository) {
    fun createCastle(castle: Castle):Castle{
        return castleRepository.save(castle)
    }

    fun getAllCastles(): List<Castle> {
         return castleRepository.findAll().toList()
    }



    fun getCastleById(id: Long): Castle {
        return castleRepository.findById(id).orElseThrow {CastleException("Castle not found by id $id")}

    }
    fun updateCastle(id: Long,castle: Castle): Castle {
        val existingCastle=getCastleById(id);
        existingCastle.name=castle.name;
        existingCastle.description=castle.description;
        return castleRepository.save(existingCastle);
    }

    fun deleteCastle(id: Long){
        castleRepository.deleteById(id);

    }

    fun getCastlesByName(name: String): List<Castle> {
        return castleRepository.findByNameContaining(name);
    }
}