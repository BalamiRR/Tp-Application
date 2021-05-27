import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Team } from '@team-handling/teams/models/team';
import { TeamService } from '@team-handling/teams/services/team.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-team-listing',
  templateUrl: './team-listing.component.html',
  styleUrls: ['./team-listing.component.css']
})

export class TeamListingComponent implements OnInit {

  constructor(private teamService : TeamService) { 
  }

  ngOnInit(): void {
  }

}



