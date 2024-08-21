package com.example.Voting.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Voting.Entity.Votes;

public interface VotesRepository extends JpaRepository<Votes, Integer> {

	Optional<Votes> findByVid(int vid);
	Optional<Integer> countByCid(int cid);
}
