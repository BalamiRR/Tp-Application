import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeamListingComponent } from './teams/containers/team-listing/team-listing.component';

const routes: Routes = [
  {path:'', redirectTo:'teams', pathMatch:'full'},
  {path: 'teams', component:TeamListingComponent}
  
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }