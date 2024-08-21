package com.example.Voting.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Voting.Entity.Voter;

public interface VoterRepository extends JpaRepository<Voter, Integer>{

    Optional<Voter> findByIdAndRole(int id, String role);

}
