package com.malfargats.gestio.mapper
import com.malfargats.gestio.dto.PositionDTO
import com.malfargats.gestio.dto.SvgDataDTO
import com.malfargats.gestio.dto.SvgDataPosition
import com.malfargats.gestio.entity.Position
import org.springframework.stereotype.Component

@Component
class PositionMapper {
    fun toDTO(position: Position): PositionDTO {
        return PositionDTO(
            id = position.id,
            rol = position.rol,
            svgData = position.svgData?.let {
                    SvgDataPosition(x=it.x,y=it.y, width = it.width, height = it.height,rx=it.rx,ry=it.ry,
                        fill=it.fill,stroke=it.stroke,role=position.rol.name, viewBox = it.viewBox, transform = it.transform)
            },


        )
    }
}