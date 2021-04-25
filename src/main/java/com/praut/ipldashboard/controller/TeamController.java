package com.praut.ipldashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.praut.ipldashboard.model.Team;
import com.praut.ipldashboard.repository.MatchRepository;
import com.praut.ipldashboard.repository.TeamRespository;

@RestController
public class TeamController {
	private TeamRespository teamRepository;
	private MatchRepository matchRespository;

	@Autowired
	public TeamController(TeamRespository teamRepository, MatchRepository matchRespository) {
		this.teamRepository = teamRepository;
		this.matchRespository = matchRespository;
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = teamRepository.findByTeamName(teamName);
		team.setMatches(this.matchRespository.findLatestMatchesByTeamName(teamName, 4));
		return team;
	}
}
