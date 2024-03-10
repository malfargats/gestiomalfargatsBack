package com.malfargats.gestio.repository

import com.malfargats.gestio.entity.SvgData
import org.springframework.data.repository.CrudRepository

interface SvgDataRepository : CrudRepository<SvgData,Long> {

}