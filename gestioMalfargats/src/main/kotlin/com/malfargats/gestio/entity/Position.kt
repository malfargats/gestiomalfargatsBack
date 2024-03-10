package com.malfargats.gestio.entity

import jakarta.persistence.*
@Entity
@Table(name="Position")
data class Position(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val rol:Rol,
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="castle_id")
    val castle: Castle,
    @OneToOne(mappedBy = "position", cascade = [CascadeType.ALL], orphanRemoval = true)
    val svgData: SvgData?=null

)