package com.sorbonne.paris.nord.university.tpteamshandlingapi.service;

import com.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Test
    public void shouldReturnTheExpectedTeam_whenFindingAll(){
        // Given (Input):
        List<TeamEntity> allTeam = teamService.findAll();

        // When (Action):
        assertThat(allTeam).isNotNull().isNotEmpty().hasSize(5);
    }

    @Test
    public void shouldReturnTheExpectedTeam_whenFindingById(){
        // Given (Input):
        var id = 4L;
        var expectedName = "Bayern";

        // When (Action):
        TeamEntity getTeam = teamService.findById(id);

        // Then (Output):
        assertThat(getTeam.getId()).isNotNull().isEqualTo(id);
        assertThat(getTeam.getName()).isNotNull().isEqualTo(expectedName);
    }

    @Test
    public void shouldReturnTheExpectedTeam_whenInserting(){
        // Given (Input)
        var getName = "FenerBahce";
        var getSlogan = "Sari Kanarya";

        var newTeam = new TeamEntity().name("FenerBahce").slogan("Sari Kanarya");
        TeamEntity saveTeam = teamService.insertTeam(newTeam);

        // When (Action) and Then (Output):
        assertThat(saveTeam.getName())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(getName);

        assertThat(saveTeam.getSlogan())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(getSlogan);
    }

    @Test
    public void shouldReturnTheExpectedTeam_whenDeletingById(){
        // Given (Input):
        var teamId = 4L;
        // Then (Output):
        TeamEntity getTeam = teamService.findById(teamId);
        if(getTeam != null){
            teamService.deleteById(teamId);
        }
        else{
            System.out.println("It is null~~~" + teamId);
        }
    }
}

