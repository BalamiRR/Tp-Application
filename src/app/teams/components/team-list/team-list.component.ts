import { Component, Input, OnInit } from '@angular/core';
import { Team } from '@team-handling/teams/models/team';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.css']
})
export class TeamListComponent implements OnInit {

  @Input() teams: Team[] | null;

  constructor() {
    this.teams = null;
  }

  ngOnInit(): void {
  }

}
