package com.malfargats.gestio.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/help")
class GreetingController {
    @Value("\${message}")
    lateinit var message:String;
    @GetMapping("/greet")
    fun greeting():String{
        return "Hola ${message}";
    }
}