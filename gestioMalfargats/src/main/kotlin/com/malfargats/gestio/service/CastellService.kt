package com.malfargats.gestio.service

import com.malfargats.gestio.dto.CastellDTO
import com.malfargats.gestio.entity.Castell
import com.malfargats.gestio.exceptions.CastellNotFoundException
import com.malfargats.gestio.repository.CastellRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CastellService(val castellRepository: CastellRepository) {
    fun createCastell(castellDTO: CastellDTO):CastellDTO{
        val castell= Castell(id = null,nom =castellDTO.nom, altura = castellDTO.altura, dificultat = castellDTO.dificultat, castellersPerPis = castellDTO.castellersPerPis)

        castellRepository.save(castell)
        val newCastellDTO=CastellDTO(id = castell.id,nom =castellDTO.nom, altura = castellDTO.altura, dificultat = castellDTO.dificultat, castellersPerPis = castellDTO.castellersPerPis)

        return newCastellDTO

    }

    fun getAllCastells(): List<CastellDTO> {
         val castells: List<Castell> = castellRepository.findAll().toList()
         return castells.map {  CastellDTO(id = it.id,nom =it.nom, altura = it.altura, dificultat = it.dificultat, castellersPerPis = it.castellersPerPis)  }

    }

    fun updateCastell(castellDto: CastellDTO, id: Long): CastellDTO {
        val existingCastell:Optional<Castell> = castellRepository.findById(id)
        if(existingCastell.isPresent){
            return existingCastell.get().let {
                it.nom = castellDto.nom
                it.altura=castellDto.altura
                it.castellersPerPis = castellDto.castellersPerPis
                it.dificultat = castellDto.dificultat
                castellRepository.save(it)
                CastellDTO(id = it.id,nom =it.nom, altura = it.altura, dificultat = it.dificultat, castellersPerPis = it.castellersPerPis)

            }

        }else{
            throw CastellNotFoundException("No s'ha trobat castell amb id $id")
        }

    }

    fun getCastell(id: Long): CastellDTO {
        val existingCastell: Optional<Castell> = castellRepository.findById(id)
        return if(existingCastell.isPresent){
            existingCastell.get().let {
                CastellDTO(id = it.id,nom =it.nom, altura = it.altura, dificultat = it.dificultat, castellersPerPis = it.castellersPerPis)
            }
        }else{
            throw CastellNotFoundException("No s'ha trobat castell amb id $id")
        }
    }

    fun deleteCastell(id: Long){
        val existingCastell: Optional<Castell> = castellRepository.findById(id)
        return if(existingCastell.isPresent){
            existingCastell.get().let {
                castellRepository.deleteById(id)
                
            }
        }else{
            throw CastellNotFoundException("No s'ha trobat castell amb id $id")
        }

    }
}