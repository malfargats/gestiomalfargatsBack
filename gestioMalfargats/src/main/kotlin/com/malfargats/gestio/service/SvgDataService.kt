package com.malfargats.gestio.service

import com.malfargats.gestio.dto.SvgDataDTO
import com.malfargats.gestio.entity.Castle
import com.malfargats.gestio.entity.Position
import com.malfargats.gestio.entity.Rol
import com.malfargats.gestio.entity.SvgData
import com.malfargats.gestio.repository.CastleRepository
import com.malfargats.gestio.repository.PositionRepository
import com.malfargats.gestio.repository.SvgDataRepository
import org.springframework.stereotype.Service

@Service
class SvgDataService(private val svgDataRepository: SvgDataRepository,
                     private val positionRepository: PositionRepository,
                     private val castleRepository: CastleRepository
    ) {
    fun createSvg(svgDataDTO: SvgDataDTO){
        val castle:Castle = Castle(id = null,name = svgDataDTO.name, description = svgDataDTO.description);
        val createdCastle=castleRepository.save(castle);
        for(position in svgDataDTO.positions){
            val castlePosition:Position = Position(id=null,rol=Rol.valueOf(position.role), castle =createdCastle);
            val createdPosition=positionRepository.save(castlePosition);
            val svgData:SvgData=SvgData(viewBox = position.viewBox,
                x=position.x, y = position.y,rx=position.rx,ry=position.ry, width = position.width, height = position.height,
                transform = position.transform, stroke = position.stroke, fill = position.fill, position = createdPosition)
            svgDataRepository.save(svgData)
        }






    }
}