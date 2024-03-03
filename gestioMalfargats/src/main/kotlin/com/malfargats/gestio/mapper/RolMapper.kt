package com.malfargats.gestio.mapper

import com.malfargats.gestio.dto.RolDTO
import com.malfargats.gestio.entity.Rol
import com.malfargats.gestio.service.RolService
import org.springframework.stereotype.Component

@Component
class RolMapper(private val rolService: RolService) {
    fun toDTO(rol:Rol):RolDTO{
        return RolDTO(id = rol.id,name=rol.name)
    }
    fun toEntity(rolDTO: RolDTO):Rol{
        return Rol(id = rolDTO.id,name=rolDTO.name)
    }
    fun getAllRols():List<RolDTO>{
        val rols=rolService.getAllRols();
        return rols.map { toDTO(it) }
    }
    fun getRolById(id:Long):RolDTO{
        val rol=rolService.getRolById(id);
        return toDTO(rol);
    }
    fun createRol(rolDTO: RolDTO):RolDTO{
        val rol=toEntity(rolDTO);
        val createdRol=rolService.createRol(rol);
        return toDTO(createdRol);
    }
    fun updateRol(id: Long,rolDTO: RolDTO):RolDTO{
        val rol=toEntity(rolDTO);
        val updatedRol=rolService.updateRol(id,rol);
        return toDTO(updatedRol);
    }
    fun deleteRol(id:Long){
        rolService.deleteRol(id);
    }
}