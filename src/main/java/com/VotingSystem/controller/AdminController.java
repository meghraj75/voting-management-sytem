package com.VotingSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.VotingSystem.entity.Admin;
import com.VotingSystem.entity.AdminLogin;
import com.VotingSystem.entity.Voter;
import com.VotingSystem.repository.AdminRepository;
import com.VotingSystem.service.AdminService;
import com.VotingSystem.service.VoterServices;

import jakarta.validation.Valid;

@Controller

public class AdminController {
   
	@Autowired
	AdminRepository adminrepository;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	VoterServices voterService;
	
	
	  
    @GetMapping("/adminregister")
    public String showRegisterForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminregister";
    }

    @PostMapping("/goadminregister")
    public String registerAdmin(@Valid @ModelAttribute Admin admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adminregister";
        }
        adminService.saveAdmin(admin);
        return "redirect:/adminlogin"; 
    }
    
 
    @GetMapping("/adminlogin")
    public String showAdminLogin(Model model) {
        model.addAttribute("login", new AdminLogin()); 
        return "adminlogin";
    }
    
    @GetMapping("/admindetails")
    public String showAdminDetails(Model model) {
      
        Admin admin = adminrepository.findAll().stream().findFirst().orElse(null);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "admindetails"; 
        }
        return "redirect:/adminlogin"; 
    }
    
    
    @GetMapping("/voters")
    public String getAllVoters(Model model) {
        List<Voter> voters = voterService.getAllVoters();
        long voterCount = voterService.getVoterCount();
        model.addAttribute("voters", voters);
        model.addAttribute("voterCount", voterCount);
        return "voters";
    }
    
    @GetMapping("/voters/delete/{id}")
    public String deleteVoter(@PathVariable("id") int id, Model model) {
        voterService.deleteVoter(id);
        return "redirect:/voters"; 
    }

    }

