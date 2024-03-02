package com.malfargats.gestio.dto

import jakarta.validation.constraints.NotBlank

data class RolDTO (

        var id:Long?,
        @NotBlank(message = "RolDTO.name is mandatory")
        var name:String
)

