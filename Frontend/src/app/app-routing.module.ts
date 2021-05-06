import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddclubComponent } from './addclub/addclub.component';
import { MatchTableComponent } from './match-table/match-table.component';
import { TableComponent } from './table/table.component';
import { AddMatchComponent} from '../app/add-match/add-match.component'
import { FindMatchComponent } from './find-match/find-match.component';

const routes: Routes = [
  { path:'table' , component : TableComponent},
  { path:'club', component : AddclubComponent},
  { path:'matches', component : MatchTableComponent},
  { path:'addmatch', component : AddMatchComponent},
  {path:'find',component:FindMatchComponent},
  {path:'addmatch',component:AddMatchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
export const RoutingComponents = [TableComponent,AddclubComponent,MatchTableComponent,AddMatchComponent,FindMatchComponent,AddMatchComponent]

