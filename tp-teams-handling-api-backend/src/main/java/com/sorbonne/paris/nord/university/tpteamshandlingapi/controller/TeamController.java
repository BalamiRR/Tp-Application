package com.sorbonne.paris.nord.university.tpteamshandlingapi.controller;

import com.sorbonne.paris.nord.university.tpteamshandlingapi.dto.TeamDto;
import com.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import com.sorbonne.paris.nord.university.tpteamshandlingapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TeamController{

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<TeamDto> gettingTeams(){
        return teamService.findAll().stream().map(this::toDto).collect(toList());
    }

    @GetMapping("/teams/{id}")
    public TeamDto gettingTeamById(@PathVariable Long id){
        TeamEntity teamEntity = teamService.findById(id);
        return toDto(teamEntity);
    }

    @PostMapping("/teams")
    public TeamDto insertingTeam(@RequestBody TeamDto teamDto){
        TeamEntity teamEntity = teamService.insertTeam(toEntity(teamDto));
        return toDto(teamEntity);
    }

    @PutMapping("/teams")
    public TeamEntity updatingTeam(@RequestBody TeamEntity teamEntity){
        teamService.insertTeam(teamEntity);
        return teamEntity;
    }

    @DeleteMapping("teams/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteById(id);
    }

    private TeamDto toDto(TeamEntity teamEntity){
        return new TeamDto(teamEntity.getId(), teamEntity.getName(), teamEntity.getSlogan());
    }

    private TeamEntity toEntity(TeamDto teamDto){
        return new TeamEntity().name(teamDto.name()).slogan(teamDto.slogan());
    }
}

