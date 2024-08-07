package com.VotingSystem.service;

import java.util.List;



import com.VotingSystem.entity.Voter;

public interface VoterServices {
    public Voter saveVoter(Voter voter);
//    public List<Voter>voterlist();
//    public void deleteById(int id);
//    public Voter findById(int id);
//    public Voter updateVoter(Voter voter);
	

     List<Voter> getAllVoters();

     long getVoterCount();
     void deleteVoter(int id);
}
