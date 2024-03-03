package com.malfargats.gestio.repository
import com.malfargats.gestio.entity.Member
import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<Member, Long> {
    fun findByNameContaining(name:String):List<Member>;
}