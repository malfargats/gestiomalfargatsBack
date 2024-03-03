package com.malfargats.gestio.mapper

import com.malfargats.gestio.dto.MemberDTO
import com.malfargats.gestio.entity.Member
import com.malfargats.gestio.service.MemberService
import org.springframework.stereotype.Component

@Component
class MemberMapper(private val memberService: MemberService) {
    fun toDTO(member:Member):MemberDTO{
        return MemberDTO(
            id = member.id,
            name=member.name,
            age=member.age,
            weight = member.weight,
            height = member.height


        )
    }
    fun toEntity(memberDTO:MemberDTO):Member{
        return Member(id = memberDTO.id,
            name=memberDTO.name,
            age=memberDTO.age,
            weight = memberDTO.weight,
            height = memberDTO.height)

    }
    fun createMember(memberDTO: MemberDTO):MemberDTO{
        val member=toEntity(memberDTO);
        val createdMember=memberService.createMember(member);
        return toDTO(createdMember);

    }

    fun getAllMembers(): List<MemberDTO> {
        return memberService.getAllMembers().map { toDTO(it) }
    }

    fun getMemberById(id: Long): MemberDTO {
        val member:Member=memberService.getMemberById(id);
        return toDTO(member);

    }

    fun updateMember(id: Long,memberDTO: MemberDTO): MemberDTO {
        val member:Member=toEntity(memberDTO)
        val updatedMember:Member=memberService.updateMember(id,member);
        return toDTO(updatedMember);

    }

    fun deleteMember(id: Long) {
        memberService.deleteMember(id);

    }
}