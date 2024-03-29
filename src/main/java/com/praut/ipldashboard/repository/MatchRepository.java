package com.praut.ipldashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.praut.ipldashboard.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

	public List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

	default List<Match> findLatestMatchesByTeamName(String teamName, int count){
		return this.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
	}
}
