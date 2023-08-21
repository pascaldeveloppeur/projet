package com.moriset.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriset.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findById(Integer id);

}
