package org.dev.repository;

import java.util.List;

import org.dev.model.Member;
import org.dev.model.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepo extends JpaRepository<Member, Long> {
	
	
	List<Member> findByMemberType(MemberType memberType);

}
