package com.malfargats.gestio.repository

import com.malfargats.gestio.entity.HumanTower
import org.springframework.data.repository.CrudRepository

interface HumanTowerRepository:CrudRepository<HumanTower,Long> {
}