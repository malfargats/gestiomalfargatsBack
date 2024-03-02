package com.malfargats.gestio.service
import com.malfargats.gestio.dto.RolDTO
import com.malfargats.gestio.entity.Rol
import com.malfargats.gestio.repository.RolRepository
import org.springframework.stereotype.Service
import java.util.Optional
import javax.management.relation.RoleInfoNotFoundException

@Service
class RolService(val rolRepository: RolRepository) {
    fun getAllRols() : List<RolDTO>{
        return rolRepository.findAll().map {
            it.toDTO()
        }
    }

    fun getRolById(id: Long): RolDTO {
        val existingRol=rolRepository.findById(id);
        if (existingRol.isPresent){
            return existingRol.get().toDTO()
        }else{
            throw RoleInfoNotFoundException("Not found Rol")
        }
    }

    fun createRol(rolDTO: RolDTO): RolDTO {
        val rol:Rol=rolDTO.toRol()
        val savedRol=rolRepository.save(rol);
        return savedRol.toDTO();
    }
    fun updateRol(id:Long,rolDTO: RolDTO):RolDTO{
        val existingRol:Optional<Rol> = rolRepository.findById(id);
        if(!existingRol.isPresent) throw  RoleInfoNotFoundException("Not found")
        val rol:Rol = existingRol.get();
        rol.name=rolDTO.name;
        return rolRepository.save(rol).toDTO();

    }
    fun deleteRol(id: Long){
        rolRepository.deleteById(id)
    }
}