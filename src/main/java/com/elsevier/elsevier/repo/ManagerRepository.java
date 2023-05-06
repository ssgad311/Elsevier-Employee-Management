package com.elsevier.elsevier.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elsevier.elsevier.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	Manager findByUsername(String username);
	
	@Query(value ="SELECT * FROM Manager m WHERE " +
            "m.manager_username=:username and m.manager_password=:password",nativeQuery = true)
	Manager findByUsernameAndPassword(String username,String password);
	
	@Query(value ="SELECT * FROM Manager m WHERE " +
            "m.manager_id=:managerId",nativeQuery = true)
	Manager findByUserId(Integer managerId);
}
