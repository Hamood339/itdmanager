import { NgModule } from '@angular/core';
import HomeComponent from './home.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import LoginComponent from '../../login/login.component';

import { EtudiantComponent } from './etudiant/etudiant.component';
import { Home2Component } from './etudiant/home2/home2.component';
import { NotificationComponent } from './notification/notification.component';
import { NotesComponent } from './etudiant/notes/notes.component';
import { AdministrationComponent } from './administration/administration.component';
import { ProfesseurComponent } from './professeur/professeur.component';
import { CertificationsComponent } from './certifications/certifications.component';
import { EmpoiDuTempsComponent } from '../../empoi-du-temps/empoi-du-temps.component';


const routes: Routes = [
  { path: '', component: HomeComponent }, // Route pour le composant d'accueil
  {path:'login', component:LoginComponent},
  {path:'acceuil',component:Home2Component},
  {path:'student',component:EtudiantComponent},
  {path:'notifs',component:NotificationComponent},
  {path:'notes',component:NotesComponent},
  {path:'admini',component:AdministrationComponent},
  {path:'certifs',component:CertificationsComponent},
  {path:'profs',component:ProfesseurComponent},
  {path:'emploi',component:EmpoiDuTempsComponent},
];
@NgModule({
  declarations:[

  ],
  imports: [
    EtudiantComponent,
    ProfesseurComponent,
    CertificationsComponent,
    AdministrationComponent,
    NotificationComponent,
    NotesComponent,
    EtudiantComponent,
    BrowserModule,
    RouterModule.forRoot(routes),
    HomeComponent,
    LoginComponent,
    Home2Component,
  ],
  providers:[],
  bootstrap:[]
})
export class HomeModule{

}
