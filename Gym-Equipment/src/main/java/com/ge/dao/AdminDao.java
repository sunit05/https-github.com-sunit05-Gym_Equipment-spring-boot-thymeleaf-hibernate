package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.Admin;
import com.ge.repository.GymRepository;

@Component
public class AdminDao {

	@Autowired
	GymRepository gymRepository;
	
	public List<Admin> getAllAdmins(){
		return gymRepository.findAll();
	}
	
	public Admin saveAdmin(Admin admin) {
		return gymRepository.save(admin);
	}
	
	
}