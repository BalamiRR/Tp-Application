import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeamListComponent } from './teams/components/team-list/team-list.component';
import { TeamDetailComponent } from './teams/components/team-detail/team-detail.component';
import { TeamListingComponent } from './teams/containers/team-listing/team-listing.component';
import { TeamService } from './teams/services/team.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    TeamListingComponent,
    TeamListComponent,
    TeamDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [TeamService],
  bootstrap: [AppComponent]
})
export class AppModule { }
