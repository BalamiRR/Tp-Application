import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Team } from './teams/models/team';
import { TeamService } from './teams/services/team.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'tp-teams-handling-api-frontend';

  public teams: Team[];
  
  constructor(private teamService: TeamService){}
  ngOnInit(){
    this.getTeams();
  }

  public getTeams(): void {
    this.teamService.getTeams().subscribe(
      (response: Team[])=> {
        this.teams = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message)
      }
      );
  }


}
