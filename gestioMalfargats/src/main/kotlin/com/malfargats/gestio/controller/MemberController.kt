package com.malfargats.gestio.controller

import com.malfargats.gestio.dto.MemberDTO
import com.malfargats.gestio.mapper.MemberMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(private val memberMapper: MemberMapper) {
    @GetMapping
    fun getAllMembers():ResponseEntity<List<MemberDTO>>{
        val members:List<MemberDTO> =memberMapper.getAllMembers();
        return ResponseEntity.ok(members);
    }
    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id:Long):ResponseEntity<MemberDTO>{
        val member=memberMapper.getMemberById(id);
        return ResponseEntity.ok(member);
    }
    @PostMapping
    fun createMember(@RequestBody memberDTO: MemberDTO):ResponseEntity<MemberDTO>{
        val member=memberMapper.createMember(memberDTO);
        return ResponseEntity.ok().body(member);
    }
    @PutMapping("/{id}")
    fun updateMember(@PathVariable id:Long,@RequestBody memberDTO:MemberDTO):ResponseEntity<MemberDTO>{
        val updatedMember:MemberDTO=memberMapper.updateMember(id,memberDTO);
        return ResponseEntity.ok().body(updatedMember);
    }
    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id:Long):ResponseEntity<Void>{
        memberMapper.deleteMember(id);
        return ResponseEntity.noContent().build();
    }




}