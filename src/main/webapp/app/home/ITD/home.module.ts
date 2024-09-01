import { NgModule } from '@angular/core';
import HomeComponent from './home.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import LoginComponent from '../../login/login.component';

import { AcceuilComponent } from '../../acceuil/acceuil.component';
import { EtudiantComponent } from '../../etudiant/etudiant.component';

const routes: Routes = [
  { path: '', component: HomeComponent }, // Route pour le composant d'accueil
  {path:'login', component:LoginComponent},
  {path:'acceuil',component:AcceuilComponent},
  {path:'student',component:EtudiantComponent}
];
@NgModule({
  declarations:[


  ],
  imports: [
    EtudiantComponent,
    BrowserModule,
    RouterModule.forRoot(routes),
    HomeComponent,
    LoginComponent,
   AcceuilComponent,

  ],
  providers:[],
  bootstrap:[]
})
export class HomeModule{

}
