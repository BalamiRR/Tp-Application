  import {NgModule} from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { TeamDetailComponent } from './components/team-detail/team-detail.component';
import { TeamDeleteComponent } from './containers/team-delete/team-delete.component';
import { TeamInsertComponent } from './containers/team-insert/team-insert.component';
import { TeamListingComponent } from './containers/team-listing/team-listing.component';
import { TeamUpdateComponent } from './containers/team-update/team-update.component';

@NgModule({
  declarations: [
    TeamListingComponent,
    TeamUpdateComponent,
    TeamInsertComponent,
    TeamDeleteComponent,
    TeamDetailComponent
  ],
  imports: [
    ReactiveFormsModule,
  ]
})
export class TeamsModule {
}
