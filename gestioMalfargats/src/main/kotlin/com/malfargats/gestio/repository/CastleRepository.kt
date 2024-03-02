package com.malfargats.gestio.repository

import com.malfargats.gestio.entity.Castle
import org.springframework.data.repository.CrudRepository

interface CastleRepository:CrudRepository<Castle,Long> {
    fun findByNameContaining(name:String):List<Castle>;
}