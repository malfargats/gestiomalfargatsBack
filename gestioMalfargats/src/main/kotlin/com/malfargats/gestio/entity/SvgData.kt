package com.malfargats.gestio.entity

import jakarta.persistence.*

@Entity
@Table(name="svg_data")
class SvgData (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?=null,
    @Column(nullable=false)
    val viewBox:String,
    @Column(nullable = false)
    val x:Double,
    @Column(nullable = false)
    val y:Double,
    @Column(nullable = false)
    val rx:Double,
    @Column(nullable = false)
    val ry:Double,
    @Column(nullable = false)
    val width:Double,
    @Column(nullable = false)
    val height:Double,
    val transform:String?,
    @Column(nullable = false)
    val fill:String,
    @Column(nullable = false)
    val stroke:String,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="position_id")
    val position:Position?
)


