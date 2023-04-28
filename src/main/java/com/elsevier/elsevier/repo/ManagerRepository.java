package com.elsevier.elsevier.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsevier.elsevier.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	Manager findByUsername(String username);
}
