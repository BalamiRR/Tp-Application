import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Team } from '../models/team';
import { Router } from '@angular/router';
import { environment } from '@team-handling-env/environment';

@Injectable({
  providedIn: 'root'
})

export class TeamService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(`${this.apiServerUrl}/teams`);
  }

  public addTeams(teams: Team): Observable<Team> {
    return this.http.post<Team>(`${this.apiServerUrl}/teams`,teams);
  }
}

