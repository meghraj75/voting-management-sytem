package com.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


import com.VotingSystem.entity.Voter;
import com.VotingSystem.entity.VoterLogin;
import com.VotingSystem.service.VoterLoginService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class VoterLoginController {

    @Autowired
    private VoterLoginService voterLoginService;
 
   
 


    @PostMapping("/voterloginstatus")
    public String handleLogin(@Valid @ModelAttribute("voterlogin") VoterLogin voterlogin,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "voterlogin";
        }

        
        Voter voter = voterLoginService.getVoterByUsername(voterlogin.getUsername());

        if (voter != null && voter.getPassword().equals(voterlogin.getPassword())) {
           
            voterLoginService.saveVoterLoginRecord(voterlogin.getUsername());
            return "redirect:/voterHome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "voterlogin";
        }
    }

  
    @GetMapping("/votersuccess")
    public String showSuccessPage() {
        return "voterHome";
    }
}
