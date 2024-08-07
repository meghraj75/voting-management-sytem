
package com.VotingSystem.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.VotingSystem.entity.Admin;
import com.VotingSystem.entity.AdminLogin;
import com.VotingSystem.repository.AdminLoginRepository;
import com.VotingSystem.service.AdminService;

import jakarta.validation.Valid;
@Controller
public class AdminLoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminLoginRepository adminLoginRepository;
    @PostMapping("/adminloginstatus")
    public String getAdminLoginStatus(@Valid @ModelAttribute("adminlogin") AdminLogin adminLogin,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "adminlogin"; 
        }

        Admin admin = adminService.getAdminByUsername(adminLogin.getUsername());

       
        if (admin != null && admin.getPassword().equals(adminLogin.getPassword())) {
        	 adminLoginRepository.save(adminLogin);
            return "redirect:/adminHome"; 
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminlogin";
           
        }
    }
    
    @GetMapping("/adminHome")
    public String showAdminSuccess() {
        return "adminHome";
    }
}


