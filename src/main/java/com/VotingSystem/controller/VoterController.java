package com.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.VotingSystem.entity.Voter;
import com.VotingSystem.repository.VoterRepository;
import com.VotingSystem.service.VoterServices;

import jakarta.validation.Valid;

@Controller

public class VoterController {

    @Autowired
    VoterRepository voterRepo;

    @Autowired
    VoterServices voterService;

    @GetMapping("/voterregister")
    public String showRegisterForm(Model model) {
        model.addAttribute("voter", new Voter());
        return "voterregister";
    }

    @PostMapping("/govoterregister")
    public String registerVoter(@Valid @ModelAttribute("voter") Voter voter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "voterregister";
        }
        voterService.saveVoter(voter);
        return "redirect:/voterlogin";
    }
    
    
    @GetMapping("/voterlogin")
    public String showLoginForm(Model model) {
        model.addAttribute("voterlogin", new Voter());
        return "voterlogin";
    }
    
    @GetMapping("/voters/update")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Voter voter = voterRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid voter Id:" + id));
        model.addAttribute("voter", voter);
        return "updateVoters";
    }

    @PostMapping("/voters/update")
    public String updateVoter(@Valid @ModelAttribute("voter") Voter voter, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "updateVoters";
        }

        voterRepo.save(voter);
        return "redirect:/voters";
    }
   
    
    
}
