package com.malfargats.gestio.repository

import com.malfargats.gestio.entity.HumanTower
import com.malfargats.gestio.entity.HumanTowerPositionsConfig
import org.springframework.data.repository.CrudRepository

interface HumanTowerPositionsConfigRepository : CrudRepository<HumanTowerPositionsConfig,Long> {
    fun findByHumanTower(humanTower: HumanTower): List<HumanTowerPositionsConfig>

}
