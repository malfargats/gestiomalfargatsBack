package com.malfargats.gestio.dto

import com.malfargats.gestio.entity.Rol
import jakarta.validation.constraints.NotBlank

data class RolDTO (

        var id:Long?=null,
        @NotBlank(message = "RolDTO.name is mandatory")
        var name:String
){
        fun toRol():Rol{
                return Rol(id,name);


        }
}

