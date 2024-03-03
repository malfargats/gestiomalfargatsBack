package com.malfargats.gestio.service
import com.malfargats.gestio.dto.RolDTO
import com.malfargats.gestio.entity.Rol
import com.malfargats.gestio.exceptions.RolException
import com.malfargats.gestio.repository.RolRepository
import org.springframework.stereotype.Service
import java.util.Optional
import javax.management.relation.RoleInfoNotFoundException

@Service
class RolService(val rolRepository: RolRepository) {
    fun getAllRols() : List<Rol>{
        return rolRepository.findAll().toList();
    }

    fun getRolById(id: Long): Rol {
        return rolRepository.findById(id).orElseThrow{RolException("Role not found with id $id")}
    }

    fun createRol(rol: Rol): Rol {

        return rolRepository.save(rol);

    }
    fun updateRol(id:Long,rol: Rol):Rol{
        val existingRol=getRolById(id);
        existingRol.name=rol.name;
        return rolRepository.save(existingRol);

    }
    fun deleteRol(id: Long){
        rolRepository.deleteById(id)
    }
}