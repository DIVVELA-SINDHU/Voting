package com.example.Voting.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Voting.Entity.Voter;
import com.example.Voting.Entity.Votes;
import com.example.Voting.Repository.VoterRepository;
import com.example.Voting.Repository.VotesRepository;

@Service
public class VotingService {
	
	@Autowired
	VoterRepository vr;
	
	@Autowired
	VotesRepository vs;
	
	public String greetings()
	{
		return "Hai, from service class";
	}
	
	public String addVoter(Voter v)
	{
		String msg="Check the details";
		try {
			vr.save(v);
			msg="Voter Added Successfully";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return msg;
	}
	
	public String castVote(Votes v)
	{
		String msg="Check the details";
		try {
			Voter v1=vr.findByIdAndRole(v.getVid(),"voter")
					.orElseThrow(()-> new RuntimeException("Voter not found"));
			System.out.println("voter details: "+v1.toString());
			Voter v2=vr.findByIdAndRole(v.getCid(), "candidate")
					 .orElseThrow(()-> new RuntimeException("candidate not found"));
			System.out.println("voter details: "+v2.toString());
			if(vs.findByVid(v.getVid()).isPresent())
			{
				throw new RuntimeException("Voter already casted");
			}
			vs.save(v);
			msg="Vote casted";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return msg;
	}
	
	public String countVotes(int cid)
	{
		String msg="Not counted";
		try {
			Voter v2=vr.findByIdAndRole(cid, "candidate")
					 .orElseThrow(()-> new RuntimeException("candidate not found"));
			System.out.println("voter details: "+v2.toString());
			Integer n=vs.countByCid(cid)
					.orElseThrow(()-> new RuntimeException("Error while counting"));
			System.out.println(n);
			msg="Votes you got:"+n;
			
		}catch(Exception e)
		{
			return e.getMessage();
		}
		return msg;
	}
}
