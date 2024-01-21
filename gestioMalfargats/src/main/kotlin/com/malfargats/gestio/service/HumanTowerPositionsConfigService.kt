package com.malfargats.gestio.service

import com.malfargats.gestio.dto.HumanTowerPositionsConfigDTO
import com.malfargats.gestio.entity.HumanTower
import com.malfargats.gestio.entity.HumanTowerPositionsConfig
import com.malfargats.gestio.exceptions.HumanTowerNotFoundException
import com.malfargats.gestio.repository.HumanTowerPositionsConfigRepository
import com.malfargats.gestio.repository.HumanTowerRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class HumanTowerPositionsConfigService(val humanTowerPositionsConfigRepository: HumanTowerPositionsConfigRepository,val humanTowerRepository: HumanTowerRepository) {
    fun createHumanTowerPositionsConfig(humanTowerPositionsConfigDTO: HumanTowerPositionsConfigDTO){
        val humanTowerPositionsConfigEntity=humanTowerPositionsConfigDTO.let {
            HumanTowerPositionsConfig(id=null, humanTower = it.humanTower,
                    position = it.position, offsetX = it.offsetX, offsetY = it.offsetY, rotation = it.rotation)

        }
        humanTowerPositionsConfigRepository.save(humanTowerPositionsConfigEntity)
        return humanTowerPositionsConfigEntity.let{
            HumanTowerPositionsConfigDTO(id=null, humanTower = it.humanTower,
                    position = it.position, offsetX = it.offsetX, offsetY = it.offsetY, rotation = it.rotation)
        }
    }

    fun getAllHumanTowerPositionsConfigById(humanTowerId: Long): List<HumanTowerPositionsConfigDTO> {
        val humanTowerEntity: Optional<HumanTower> = humanTowerRepository.findById(humanTowerId)
        if (humanTowerEntity.isPresent) {
            return humanTowerPositionsConfigRepository.findByHumanTower(humanTowerEntity.get()).map { it ->
                HumanTowerPositionsConfigDTO(id = null, humanTower = it.humanTower,
                        position = it.position, offsetX = it.offsetX, offsetY = it.offsetY, rotation = it.rotation)
            }
        } else {
            throw HumanTowerNotFoundException("That human tower does not exist")
        }


    }
}
