package com.malfargats.gestio.dto
data class SvgDataDTO (
    val id: Long?,
    val name: String,
    val description:String,
    val positions:List<SvgDataPosition>

)
data class SvgDataPosition(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double,
    val rx: Double,
    val ry: Double,
    val fill: String,
    val stroke: String,
    val role: String,
    val viewBox: String,
    val transform: String?=null
)
