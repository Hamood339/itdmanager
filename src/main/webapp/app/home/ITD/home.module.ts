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
<<<<<<< HEAD

import { EmploiDuTempsComponent } from '../../emploi-du-temps/emploi-du-temps.component';
=======
import { CertificationsComponent } from './etudiant/certifications/certifications.component';
import { EmpoiDuTempsComponent } from './etudiant/empoi-du-temps/empoi-du-temps.component';
import { EmploiDuTempsComponent } from './etudiant/emploi-du-temps/emploi-du-temps.component';
>>>>>>> f5c0d2dbebb29e6aa764dfbee5629ae581e0128a


const routes: Routes = [
  { path: '', component: HomeComponent }, // Route pour le composant d'accueil
  {path:'login', component:LoginComponent},
  {path:'acceuil',component:Home2Component},
  {path:'student',component:EtudiantComponent},
  {path:'notifs',component:NotificationComponent},
  {path:'notes',component:NotesComponent},
  {path:'admini',component:AdministrationComponent},

  {path:'profs',component:ProfesseurComponent},
  {path:'emploi',component:EmploiDuTempsComponent},
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
    EmploiDuTempsComponent,
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
