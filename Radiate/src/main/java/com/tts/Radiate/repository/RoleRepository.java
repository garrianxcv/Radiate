package com.tts.Radiate.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.Radiate.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	@Query
	Role findByRole(String role);
}

