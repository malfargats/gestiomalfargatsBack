package com.malfargats.gestio.mapper

import com.malfargats.gestio.dto.CastleDTO
import com.malfargats.gestio.entity.Castle
import com.malfargats.gestio.service.CastleService
import org.springframework.stereotype.Component

@Component
class CastleMapper(private val castleService: CastleService) {
    fun toDTO(castle: Castle):CastleDTO{
        return  CastleDTO(id=castle.id,name=castle.name, description = castle.description)
    }
    fun toEntity(castle: CastleDTO):Castle{
        return Castle(id=castle.id,name=castle.name, description = castle.description)
    }
    fun getAllCastles():List<CastleDTO>{
        return castleService.getAllCastles().map { toDTO(it) }
    }
    fun getCastleById(id:Long):CastleDTO{
        val castle=castleService.getCastleById(id);
        return toDTO(castle);

    }
    fun createCastle(castleDTO:CastleDTO):CastleDTO{
        val castle=toEntity(castleDTO);
        val createdCastle=castleService.createCastle(castle);
        return toDTO(createdCastle);
    }
    fun updateCastle(id: Long,castleDTO: CastleDTO):CastleDTO{
        val castle=toEntity(castleDTO);
        val updatedCastle=castleService.updateCastle(id,castle);
        return toDTO(updatedCastle);
    }
    fun deleteCastle(id: Long){
        castleService.deleteCastle(id);
    }

}