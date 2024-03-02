package com.malfargats.gestio.service

import com.malfargats.gestio.dto.CastleDTO
import com.malfargats.gestio.entity.Castle
import com.malfargats.gestio.exceptions.CastleNotFoundException
import com.malfargats.gestio.repository.CastleRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CastleService(val castleRepository: CastleRepository) {
    fun createCastle(castleDTO: CastleDTO):CastleDTO{
        val castle= castleDTO.toCastle();
        val savedCastle=castleRepository.save(castle)
        return savedCastle.toDTO();

    }

    fun getAllCastles(): List<CastleDTO> {
         val castles: List<Castle> = castleRepository.findAll().toList()
         return castles.map {  it.toDTO()  }

    }

    fun updateCastle(castleDto: CastleDTO, id: Long): CastleDTO {
        val existingCastle:Optional<Castle> = castleRepository.findById(id)
        if(existingCastle.isPresent){
            val castle:Castle=existingCastle.get();
            castle.name=castleDto.name;
            castle.description=castleDto.description;
            return castleRepository.save(castle).toDTO()

        }else{
            throw CastleNotFoundException("No s'ha trobat castle amb id $id")
        }

    }

    fun getCastle(id: Long): CastleDTO {
        val existingCastle: Optional<Castle> = castleRepository.findById(id)
         if(existingCastle.isPresent){
            return existingCastle.get().toDTO()

        }else{
            throw CastleNotFoundException("No s'ha trobat castle amb id $id")
        }
    }

    fun deleteCastle(id: Long){
        val existingCastle: Optional<Castle> = castleRepository.findById(id)
        return if(existingCastle.isPresent){
            existingCastle.get().let {
                castleRepository.deleteById(id)
                
            }
        }else{
            throw CastleNotFoundException("No s'ha trobat castle amb id $id")
        }

    }

    fun getCastlesByName(name: String): List<CastleDTO> {
        return castleRepository.findByNameContaining(name).map {
            it.toDTO()
        }

    }
}