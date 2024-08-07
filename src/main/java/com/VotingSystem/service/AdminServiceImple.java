package com.VotingSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.VotingSystem.entity.Admin;
import com.VotingSystem.entity.AdminLogin;
import com.VotingSystem.repository.AdminLoginRepository;
import com.VotingSystem.repository.AdminRepository;


@Service
public class AdminServiceImple implements AdminService {

	  @Autowired
	    private AdminRepository adminRepository;

	    @Autowired
	    private AdminLoginRepository adminLoginRepository;

	    @Override
	    public void saveAdmin(Admin admin) {
	        adminRepository.save(admin);
	    }

	    @Override
	    public List<Admin> adminlist() {
	        return adminRepository.findAll();
	    }

	    @Override
	    public void saveAdminLogin(AdminLogin adminLogin) {
	        adminLoginRepository.save(adminLogin);
	    }

		
		@Override
		public Admin getAdminByUsername(String username) {
		    return adminRepository.findByUsername(username); // Ensure that username is unique
		}
}
