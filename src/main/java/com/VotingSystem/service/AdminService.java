package com.VotingSystem.service;

import java.util.List;
import com.VotingSystem.entity.Admin;
import com.VotingSystem.entity.AdminLogin;

public interface AdminService {
    void saveAdmin(Admin admin);
    List<Admin> adminlist();
    void saveAdminLogin(AdminLogin adminLogin);  
    Admin getAdminByUsername(String username); // Method to get admin by username
}
