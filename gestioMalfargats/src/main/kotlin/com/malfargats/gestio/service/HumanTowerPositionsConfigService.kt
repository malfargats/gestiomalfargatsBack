package com.malfargats.gestio.service

import com.malfargats.gestio.dto.HumanTowerPositionsConfigDTO
import com.malfargats.gestio.entity.HumanTower
import com.malfargats.gestio.entity.HumanTowerPositionsConfig
import com.malfargats.gestio.exceptions.HumanTowerNotFoundException
import com.malfargats.gestio.repository.HumanTowerPositionsConfigRepository
import com.malfargats.gestio.repository.HumanTowerRepository
import com.malfargats.gestio.repository.PositionRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class HumanTowerPositionsConfigService(val humanTowerPositionsConfigRepository: HumanTowerPositionsConfigRepository,val humanTowerRepository: HumanTowerRepository,val positionRepository: PositionRepository) {
    fun createHumanTowerPositionsConfig(humanTowerPositionsConfigDTO: HumanTowerPositionsConfigDTO){
        val humanTowerEntity=humanTowerRepository.findById(humanTowerPositionsConfigDTO.humanTower.id!!)
        if(!humanTowerEntity.isPresent){
            throw HumanTowerNotFoundException("Human tower not valid")
        }
        val positionEntity=positionRepository.findById(humanTowerPositionsConfigDTO.position.id!!)
        val humanTowerPositionsConfigEntity=humanTowerPositionsConfigDTO.let {
            HumanTowerPositionsConfig(id=null, humanTower = humanTowerEntity.get(),
                    position = positionEntity.get(), offsetX = it.offsetX, offsetY = it.offsetY, rotation = it.rotation)

        }
        humanTowerPositionsConfigRepository.save(humanTowerPositionsConfigEntity)
        return humanTowerPositionsConfigEntity.let{
            HumanTowerPositionsConfigDTO(id=null, humanTower = humanTowerPositionsConfigDTO.humanTower,
                    position = humanTowerPositionsConfigDTO.position, offsetX = it.offsetX, offsetY = it.offsetY, rotation = it.rotation)
        }
    }

    fun getAllHumanTowerPositionsConfigById(humanTowerId: Long): List<HumanTowerPositionsConfigDTO> {
        val humanTowerEntity: Optional<HumanTower> = humanTowerRepository.findById(humanTowerId)
        if(!humanTowerEntity.isPresent){
            throw HumanTowerNotFoundException("Human tower not valid")
        }

            return humanTowerPositionsConfigRepository.findByHumanTower(humanTowerEntity.get()).map { it ->
                HumanTowerPositionsConfigDTO(id = null, humanTower = it.humanTower,
                        position = it.position, offsetX = it.offsetX, offsetY = it.offsetY, rotation = it.rotation)
            }



    }
}
