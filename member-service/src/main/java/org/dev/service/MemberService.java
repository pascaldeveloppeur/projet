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





@Service
public class MemberService {
	
	@Autowired
	private MemberRepo memberRepo;
	
	public Optional<Member> getMemberById(Long id) {
		Optional<Member> member = memberRepo.findById(id);
		return member;
	}
	
	public List<Member> getAllMembers(){
		List<Member> list=  memberRepo.findAll();
		return list ;
	}
	
	public List<Member> gerAllMembersByType(MemberType type){
		List<Member> lisMember= memberRepo.findByType(type);
		
		return lisMember ;
	}
	
	public Member saveMember(Member member) {
		Member member1 = memberRepo.save(member);
		return member1;
	}
	
	public void deleteMember(Long id) {
		
		memberRepo.deleteById(id);
		
	}
	public void deleteMembers() {
		memberRepo.deleteAll();
	}

}
