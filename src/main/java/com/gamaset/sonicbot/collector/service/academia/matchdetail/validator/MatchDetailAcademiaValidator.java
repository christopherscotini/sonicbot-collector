package com.gamaset.sonicbot.collector.service.academia.matchdetail.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchStatusEnum;
import com.gamaset.sonicbot.collector.infra.exception.DataEntryInvalidException;

@Component
public class MatchDetailAcademiaValidator {

	private boolean validateEnumMatchStatus(MatchStatusEnum mse){
		for (MatchStatusEnum _mse : MatchStatusEnum.values()) {
			if (_mse.name().equals(mse.name())) {
				if(mse.name().equals(MatchStatusEnum.CANCELADO.name()) || mse.name().equals(MatchStatusEnum.ADIADO.name())
						|| mse.name().equals(MatchStatusEnum.SUSPENSO.name())){
					return true;
				}
			}
		}

		return false;
	}

	private boolean validateFieldString(String field){
		if(field == null || field.trim().isEmpty()){
			return false;
		}

		return true;
	}

	private boolean validateFieldLong(Long field){
		if(field == null || field == 0){
			return false;
		}
		
		return true;
	}

	private boolean validateFieldLink(String link, Long id){
		if(validateFieldString(link)){
			Pattern reg = Pattern.compile("(?i)^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)(?::\\d{2,5})?(?:[/?#]\\S*)?$");
			Matcher matcher = reg.matcher(link);
			if (matcher.find()){
				String[] linkSplit = link.split("/");
				if(linkSplit[linkSplit.length-1].equals(id.toString())){
					return true;
				}
			}
		}
		
		return false;
	}

	public void validate(MatchResumeDTO match) {

		if(!validateFieldLong(match.getMatchId())){
			throw new DataEntryInvalidException("matchId");
		}

		if(!validateFieldLink(match.getLinkMatch(), match.getMatchId())){
			throw new DataEntryInvalidException("linkMatch");
		}

		if(match.getMatchStatus() == null){
			throw new DataEntryInvalidException("matchStatus");
		}else{
			if(validateEnumMatchStatus(match.getMatchStatus())){
				throw new DataEntryInvalidException("matchStatus");
			}
		}

		if(match.getCompetitionSeason() == null){
			throw new DataEntryInvalidException("competitionSeason");
		}else{
			if(match.getCompetitionSeason().getCompetition() == null){
				throw new DataEntryInvalidException("competitionSeason.competition");
			}else{
				if(!validateFieldLong(match.getCompetitionSeason().getCompetition().getId())){
					throw new DataEntryInvalidException("competitionSeason.competition.id");
				}
				if(!validateFieldString(match.getCompetitionSeason().getCompetition().getName())){
					throw new DataEntryInvalidException("competitionSeason.competition.name");
				}
				if(!validateFieldLink(match.getCompetitionSeason().getCompetition().getLink(), match.getCompetitionSeason().getCompetition().getId())){
					throw new DataEntryInvalidException("competitionSeason.competition.link");
				}
			}

			if(match.getCompetitionSeason().getSeason() == null){
				throw new DataEntryInvalidException("competitionSeason.season");
			}else{
				if(!validateFieldLong(match.getCompetitionSeason().getSeason().getId())){
					throw new DataEntryInvalidException("competitionSeason.season.id");
				}
				if(!validateFieldString(match.getCompetitionSeason().getSeason().getName())){
					throw new DataEntryInvalidException("competitionSeason.season.name");
				}
			}
		}

		if(match.getHomeTeamMatch() == null){
			throw new DataEntryInvalidException("homeTeamMatch");
		}else{
			if(match.getHomeTeamMatch().getTeam() == null){
				throw new DataEntryInvalidException("homeTeamMatch.team");
			}else{
				if(!validateFieldLong(match.getHomeTeamMatch().getTeam().getId())){
					throw new DataEntryInvalidException("homeTeamMatch.team.id");
				}
				if(!validateFieldString(match.getHomeTeamMatch().getTeam().getName())){
					throw new DataEntryInvalidException("homeTeamMatch.team.name");
				}
			}
			if(match.getHomeTeamMatch().getScore() == null){
				throw new DataEntryInvalidException("homeTeamMatch.score");
			}
		}

		if(match.getAwayTeamMatch() == null){
			throw new DataEntryInvalidException("awayTeamMatch");
		}else{
			if(match.getAwayTeamMatch().getTeam() == null){
				throw new DataEntryInvalidException("awayTeamMatch.team");
			}else{
				if(!validateFieldLong(match.getAwayTeamMatch().getTeam().getId())){
					throw new DataEntryInvalidException("awayTeamMatch.team.id");
				}
				if(!validateFieldString(match.getAwayTeamMatch().getTeam().getName())){
					throw new DataEntryInvalidException("awayTeamMatch.team.name");
				}
			}
			if(match.getAwayTeamMatch().getScore() == null){
				throw new DataEntryInvalidException("awayTeamMatch.score");
			}
		}
	}

}
