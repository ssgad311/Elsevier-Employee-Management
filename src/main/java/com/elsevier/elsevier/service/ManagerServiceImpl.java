package com.elsevier.elsevier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsevier.elsevier.model.Manager;
import com.elsevier.elsevier.repo.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Manager findByUsername(String username) {
		return managerRepository.findByUsername(username);
	}

	@Override
	public void saveManager(Manager manager) {
		managerRepository.save(manager);
	}

	@Override
	public Manager validateUser(Manager manager) {
		Manager managerDetails = managerRepository.findByUsernameAndPassword(manager.getUsername(),manager.getPassword());
		List<Manager> managerList = new ArrayList<>();
		managerList.add(managerDetails);
		return managerList.size() > 0 ? managerList.get(0) : null;
	}	
	
	public List<Manager> getAllManagersList(){
		return managerRepository.findAll();
	}

	@Override
	public Manager findByManagerId(Integer managerId) {
		// TODO Auto-generated method stub
		return managerRepository.findByUserId(managerId);
	}
}
