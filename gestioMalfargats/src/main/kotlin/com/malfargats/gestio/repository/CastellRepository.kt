package com.malfargats.gestio.repository

import com.malfargats.gestio.entity.Castell
import org.springframework.data.repository.CrudRepository

interface CastellRepository:CrudRepository<Castell,Long> {
}