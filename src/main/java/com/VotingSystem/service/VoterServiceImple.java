package com.VotingSystem.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingSystem.entity.Voter;
import com.VotingSystem.repository.VoterRepository;

@Service
public class VoterServiceImple implements VoterServices{

	@Autowired
	VoterRepository voterrepo;

	@Override
	public Voter saveVoter(Voter voter) {
		
		return voterrepo.save(voter);
	}

//	@Override
//	public List<Voter> voterlist() {
//		
//		List<Voter>find=voterrepo.findAll();
//		return find;
//	}
//
//	@Override
//	public void deleteById(int id) {
//		
//		voterrepo.deleteById(id);
//	}
//
//	@Override
//	public Voter findById(int id) {
//		
//	Optional<Voter>findById=voterrepo.findById(id);
//	Voter voter=findById.get();
//	return voter;
//		
//	}
//
//	@Override
//	public Voter updateVoter(Voter voter) {
//		
//		Voter updateVoter=voterrepo.save(voter);
//		return updateVoter;
//	}

	@Override
	public List<Voter> getAllVoters() {
		return voterrepo.findAll();
	}

	@Override
	public long getVoterCount() {
		// TODO Auto-generated method stub
		return voterrepo.count();
	}

	@Override
	public void deleteVoter(int id) {
		// TODO Auto-generated method stub
	  voterrepo.deleteById(id);
	}

}
