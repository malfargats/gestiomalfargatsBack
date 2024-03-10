package com.malfargats.gestio.dto
import com.malfargats.gestio.entity.Rol


data class PositionDTO (

    val id:Long?,
    val rol: Rol,
    val svgData: SvgDataPosition?=null
)