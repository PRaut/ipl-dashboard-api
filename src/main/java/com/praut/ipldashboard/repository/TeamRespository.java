package com.praut.ipldashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praut.ipldashboard.model.Team;

public interface TeamRespository extends JpaRepository<Team, Long> {

	Team findByTeamName(String teamName);
}
