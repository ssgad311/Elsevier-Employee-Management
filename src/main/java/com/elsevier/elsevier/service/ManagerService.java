package com.elsevier.elsevier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elsevier.elsevier.model.Manager;


public interface ManagerService {

	Manager findByUsername(String username);

	void saveManager(Manager manager);
	
	Manager validateUser(Manager manager);
	
	public List<Manager> getAllManagersList();
	
	Manager findByManagerId(Integer managerId);
}
