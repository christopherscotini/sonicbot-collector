package com.gamaset.sonicbot.collector.dto;

public class TeamMatchDTO {

	private TeamDTO team;
	private Integer score = 0;

	public TeamDTO getTeam() {
		return team;
	}
	public void setTeam(TeamDTO team) {
		this.team = team;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
