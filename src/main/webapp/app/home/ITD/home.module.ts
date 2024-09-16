import { NgModule } from '@angular/core';
import HomeComponent from './home.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import LoginComponent from '../../login/login.component';

import { EtudiantComponent } from './etudiant/etudiant.component';
import { NotificationComponent } from './notification/notification.component';
import { NotesComponent } from './etudiant/notes/notes.component';
import { AdministrationComponent } from './administration/administration.component';
import { ProfesseurComponent } from './professeur/professeur.component';

const routes: Routes = [
  { path: '', component: HomeComponent }, // Route pour le composant d'accueil
  {path:'login', component:LoginComponent},

  {path:'student',component:EtudiantComponent},
  {path:'notifs',component:NotificationComponent},
  {path:'notes',component:NotesComponent},
  {path:'admini',component:AdministrationComponent},

  {path:'profs',component:ProfesseurComponent},

];
@NgModule({
  declarations:[

  ],
  imports: [
    EtudiantComponent,
    ProfesseurComponent,

    AdministrationComponent,
    NotificationComponent,
    NotesComponent,

    BrowserModule,
    RouterModule.forRoot(routes),
    HomeComponent,
    LoginComponent,

  ],
  providers:[],
  bootstrap:[]
})
export class HomeModule{

}
