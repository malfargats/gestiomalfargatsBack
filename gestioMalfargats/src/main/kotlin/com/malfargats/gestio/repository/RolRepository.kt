package com.malfargats.gestio.repository
import com.malfargats.gestio.entity.Rol
import org.springframework.data.repository.CrudRepository

interface RolRepository: CrudRepository<Rol,Long> {
    fun findByNameContaining(name:String):List<Rol>;
}