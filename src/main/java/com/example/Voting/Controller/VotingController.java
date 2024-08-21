package com.example.Voting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Voting.Entity.Voter;
import com.example.Voting.Entity.Votes;
import com.example.Voting.Service.VotingService;

@RestController
@RequestMapping("/voting")
public class VotingController {
	
	@Autowired
	VotingService vs;
	
	@GetMapping("/greet")
	public String greeting() {
		return vs.greetings();
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody Voter v)
	{
		System.out.println(v.toString());
		return vs.addVoter(v);
	}
	
	@PostMapping("/castVote")
	public String castVote(@RequestBody Votes v)
	{
		System.out.println("from Controller: "+v.toString());
		return vs.castVote(v);
	}
	
	@PostMapping("/showVotes/{cid}")
	public String showVotes(@PathVariable int cid)
	{
		System.out.println(cid);
		String n=vs.countVotes(cid);
		return n;
	}
}
