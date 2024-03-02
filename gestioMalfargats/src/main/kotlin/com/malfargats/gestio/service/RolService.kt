package com.malfargats.gestio.service
import com.malfargats.gestio.dto.RolDTO
import com.malfargats.gestio.repository.RolRepository
import org.springframework.stereotype.Service

@Service
class RolService(val rolRepository: RolRepository) {
    fun getAllRols() : List<RolDTO>{
        return rolRepository.findAll().map {
            it.toDTO()
        }
    }
}