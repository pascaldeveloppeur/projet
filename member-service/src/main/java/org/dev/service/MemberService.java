package org.dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dev.model.Member;
import org.dev.model.MemberType;
import org.dev.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;





@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private MemberRepo memberRepo;
	
	public Optional<Member> getMemberById(Long id) {
		Optional<Member> member = memberRepo.findById(id);
		if(member.isEmpty()) {
			log.trace("this member does not exist");
			return null;
		}
		return member;
	}
	
	public List<Member> getAllMembers(){
		
		log.trace("try  to find all members");
		List<Member> list=  memberRepo.findAll();
		return list ;
	}
	
	public List<Member> getAllMembersByType(MemberType type){
		
		log.trace("try to find members by memberType");
		if(type.name().isEmpty()) {
			log.trace("this member does not exist");
			return null;
		}
		List<Member> lisMember= memberRepo.findByMemberType(type);
		
		return lisMember ;
	}
	
	public Member saveMember(Member member) {
		
		log.trace("try to save member");
		Member member1 = memberRepo.save(member);
		return member1;
	}
	
	public void deleteMember(Long id) {
		log.trace("try to delete member by id");
		memberRepo.deleteById(id);
		
	}
	public void deleteMembers() {
		log.trace("try to delete all member by id");
		memberRepo.deleteAll();
	}

}
