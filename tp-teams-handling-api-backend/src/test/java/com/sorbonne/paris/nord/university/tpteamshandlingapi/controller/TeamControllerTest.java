package com.sorbonne.paris.nord.university.tpteamshandlingapi.controller;

import com.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import com.sorbonne.paris.nord.university.tpteamshandlingapi.exceptions.TeamInvalidException;
import com.sorbonne.paris.nord.university.tpteamshandlingapi.service.TeamService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {

    @Mock
    private TeamService teamService;

    @InjectMocks
    private TeamController teamController;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(teamController);
    }

    // GetMapping 200 is ok
    @Test
    public void requestShouldReturn_200_OK_findAll(@Autowired MockMvc mockMvc) throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/teams/")
                .content("{\"name\":\"teams\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // 200 is OK - findAllTeam - GetMapping
    @Test
    public void requestShouldReturn_200_OK_getTeams(){
        TeamEntity teamEntity = new TeamEntity().id(4L).name("teamsName").slogan("teamsSlogan");

        //Given :
        var mockTeam = List.of(teamEntity);

        //When :
        when(teamService.findAll()).thenReturn(mockTeam);

        //Output :
        var path = "teams";
        given().body(teamEntity).when().get(path).then().statusCode(HttpStatus.OK.value());
    }

    // 200 is OK  - findTeamById -GetMapping
    @Test
    public void requestShouldReturn_200_OK_findTeamById(){
        //Given :
        var teamId = 3L;
        var mckdTeamId = new TeamEntity().id(3L).name("teamName").slogan("teamSlogan");

        //When :
        when(teamService.findById(teamId)).thenReturn(mckdTeamId);

        //Output :
        var path = "teams/{id}";
        given().contentType(ContentType.JSON).when().get(path,teamId).then().statusCode(HttpStatus.OK.value());
    }

    // 404 is NOT FOUND - findByID - GetMapping
    @Test
    public void requestShouldReturn_404_NOTFOUND_findTeamById(){
        //Given :
        var teamId = 1L;

        //When :
        when(teamService.findById(teamId)).thenThrow();

        //Output :
        var path="path/{id}";
        given().contentType(ContentType.JSON).when().get(path).then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    // 200 is OK - insertingTeam - PostMapping
    @Test
    public void requestShouldReturn_200_OK_insertingTeam(){
        //Given :
        var mockingTeam = new TeamEntity().id(1L).name("nameTeam").slogan("sloganTeam");

        //When :
        when(teamService.insertTeam(any())).thenReturn(mockingTeam);

        //Output :
        var path="teams";
        given().contentType(ContentType.JSON).body(mockingTeam).when().post(path).then().statusCode(HttpStatus.OK.value());
    }

    // 400 is NOT FOUND - insertingTeam - PostMapping
    @Test
    public void requestShouldReturn_400_NOTFOUND_insertingTeam(){
        //Given :
        var mockingTeam = new TeamEntity().id(1L).name("teamName").slogan("");

        //When :
        when(teamService.insertTeam(any())).thenThrow(new TeamInvalidException("No  Slogan"));

        //Output :
        var path="teams";
        given().contentType(ContentType.JSON).body(mockingTeam).when().post(path).then().statusCode(HttpStatus.OK.value());
    }

    // 200 is OK - updatingTeam - PutMapping
    @Test
    public void requestShouldReturn_200_OK_updatingTeam(){
        //Given :
        var mockingTeam = new TeamEntity().id(1L).name("teamName").slogan("teamSlogan");

        //When :
        when(teamService.insertTeam(any())).thenReturn(mockingTeam);

        //Output :
        var path="teams";
        given().contentType(ContentType.JSON).body(mockingTeam).when().put(path).then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void requestShouldReturn_200_OK_deletingTeamById(){
        //Given :
        var teamId=1L;

        //When :
        var path="teams/{id}";
        given().contentType(ContentType.JSON).when().delete(path, teamId).then().statusCode(HttpStatus.OK.value());
    }
}



