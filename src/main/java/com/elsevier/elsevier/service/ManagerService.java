package com.elsevier.elsevier.service;

import org.springframework.stereotype.Service;

import com.elsevier.elsevier.model.Manager;


public interface ManagerService {

	Manager findByUsername(String username);

	void saveManager(Manager manager);
	
	Manager validateUser(Manager manager);
}
