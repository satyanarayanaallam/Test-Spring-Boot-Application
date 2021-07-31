package com.example.TestSpringBootApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TestSpringBootApplication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT t FROM User t WHERE t.name=:name")
	public List<User> findByName(@Param("name") String name);
}
