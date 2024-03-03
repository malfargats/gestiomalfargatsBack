package com.malfargats.gestio.service

import com.malfargats.gestio.entity.Member
import com.malfargats.gestio.exceptions.MemberException
import com.malfargats.gestio.repository.MemberRepository
import org.springframework.stereotype.Service


@Service
class MemberService(private val memberRepository: MemberRepository) {
    fun getAllMembers(): List<Member> {
        return memberRepository.findAll().toList();

    }
    fun getMemberById(id:Long): Member {
        return memberRepository.findById(id)
            .orElseThrow {MemberException("Member not found by id $id")}
    }
    fun createMember(member:Member):Member{
        return memberRepository.save(member);
    }
    fun updateMember(id:Long,member:Member):Member{
        val existingMember=getMemberById(id);

            return memberRepository.save(
                existingMember.copy(
                    name = member.name,age=member.age, weight = member.weight, height = member.height
                )
            )

    }

    fun deleteMember(id: Long) {
        memberRepository.deleteById(id);
    }
}