package org.dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dev.model.Member;
import org.dev.model.MemberType;
import org.dev.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMember(@PathVariable("id") Long id) {
		
		Optional<Member> member = memberService.getMemberById(id);
		
		if(member.isPresent()) {
			return new ResponseEntity<>(member.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/members")
	public ResponseEntity<List<Member>> getAllMembersByType(@RequestParam(required = false) MemberType type){
		try {
			List<Member> members = new ArrayList<Member>();
			
			if(type == null)
			{
				memberService.getAllMembers().forEach(members::add);
			}
			else {
				memberService.gerAllMembersByType(type).forEach(members::add);
			}
			
			if(members.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(members, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Member> createMember(@RequestBody Member member) {
		
		try {
			Member _member = memberService.saveMember(member);
			return new ResponseEntity<>(_member, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, 
			@RequestBody Member member){
		Optional<Member> memberData = memberService.getMemberById(id);
		
		if(memberData.isPresent()) {
			Member _member = memberData.get();
			_member.setFirstName(member.getFirstName());
			_member.setLastName(member.getLastName());
			_member.setUsername(member.getUsername());
			_member.setEmail(member.getEmail());
			_member.setPassword(member.getPassword());
			_member.setMemberType(member.getMemberType());
			return new ResponseEntity<>(memberService.saveMember(_member), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteMemberById(@PathVariable("id") Long id) {
		
		try {
			memberService.deleteMember(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<HttpStatus> deleteMembers() {
		try {
			memberService.deleteMembers();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
