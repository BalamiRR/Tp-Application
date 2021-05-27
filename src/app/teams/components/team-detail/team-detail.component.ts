import { Component, Input, OnInit } from '@angular/core';
import { Team } from '@team-handling/teams/models/team';

@Component({
  selector: 'app-team-detail',
  templateUrl: './team-detail.component.html',
  styleUrls: ['./team-detail.component.css']
})
export class TeamDetailComponent implements OnInit {

  constructor() { }

  @Input() team: Team;

  ngOnInit(): void {
    this.team = null;
  }

}
