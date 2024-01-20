package com.malfargats.gestio.service

import com.malfargats.gestio.dto.HumanTowerDTO
import com.malfargats.gestio.entity.HumanTower
import com.malfargats.gestio.exceptions.HumanTowerNotFoundException
import com.malfargats.gestio.repository.HumanTowerRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class HumanTowerService(val humanTowerRepository: HumanTowerRepository) {
    fun createHumanTower(humanTowerDTO: HumanTowerDTO):HumanTowerDTO{
        val humanTower= HumanTower(id = null,name =humanTowerDTO.name, height = humanTowerDTO.height, difficulty = humanTowerDTO.difficulty, humanTowerBuildersPerFloor = humanTowerDTO.humanTowerBuildersPerFloor)

        humanTowerRepository.save(humanTower)
        val newHumanTowerDTO=HumanTowerDTO(id = humanTower.id,name =humanTowerDTO.name, height = humanTowerDTO.height, difficulty = humanTowerDTO.difficulty, humanTowerBuildersPerFloor = humanTowerDTO.humanTowerBuildersPerFloor)

        return newHumanTowerDTO

    }

    fun getAllHumanTowers(): List<HumanTowerDTO> {
         val humanTowers: List<HumanTower> = humanTowerRepository.findAll().toList()
         return humanTowers.map {  HumanTowerDTO(id = it.id,name =it.name, height = it.height, difficulty = it.difficulty, humanTowerBuildersPerFloor = it.humanTowerBuildersPerFloor)  }

    }

    fun updateHumanTower(humanTowerDto: HumanTowerDTO, id: Long): HumanTowerDTO {
        val existingHumanTower:Optional<HumanTower> = humanTowerRepository.findById(id)
        if(existingHumanTower.isPresent){
            return existingHumanTower.get().let {
                it.name = humanTowerDto.name
                it.height=humanTowerDto.height
                it.humanTowerBuildersPerFloor = humanTowerDto.humanTowerBuildersPerFloor
                it.difficulty = humanTowerDto.difficulty
                humanTowerRepository.save(it)
                HumanTowerDTO(id = it.id,name =it.name, height = it.height, difficulty = it.difficulty, humanTowerBuildersPerFloor = it.humanTowerBuildersPerFloor)

            }

        }else{
            throw HumanTowerNotFoundException("No s'ha trobat humanTower amb id $id")
        }

    }

    fun getHumanTower(id: Long): HumanTowerDTO {
        val existingHumanTower: Optional<HumanTower> = humanTowerRepository.findById(id)
        return if(existingHumanTower.isPresent){
            existingHumanTower.get().let {
                HumanTowerDTO(id = it.id,name =it.name, height = it.height, difficulty = it.difficulty, humanTowerBuildersPerFloor = it.humanTowerBuildersPerFloor)
            }
        }else{
            throw HumanTowerNotFoundException("No s'ha trobat humanTower amb id $id")
        }
    }

    fun deleteHumanTower(id: Long){
        val existingHumanTower: Optional<HumanTower> = humanTowerRepository.findById(id)
        return if(existingHumanTower.isPresent){
            existingHumanTower.get().let {
                humanTowerRepository.deleteById(id)
                
            }
        }else{
            throw HumanTowerNotFoundException("No s'ha trobat humanTower amb id $id")
        }

    }

    fun getHumanTowersByName(name: String): List<HumanTowerDTO> {
        return humanTowerRepository.findByNameContaining(name).map {
            it->HumanTowerDTO(id = it.id,name =it.name, height = it.height, difficulty = it.difficulty, humanTowerBuildersPerFloor = it.humanTowerBuildersPerFloor)
        }

    }
}