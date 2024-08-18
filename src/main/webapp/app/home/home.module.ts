import { NgModule } from '@angular/core';
import HomeComponent from './home.component';
import { EtudiantsComponent } from '../etudiants/etudiants.component';
import { RouterModule, Routes } from '@angular/router';
import AppComponent from '../app.component';
import { BrowserModule } from '@angular/platform-browser';
const routes: Routes = [
  { path: '', component: HomeComponent }, // Route pour le composant d'accueil
  { path: 'example', component: EtudiantsComponent } // Route pour le composant que vous souhaitez afficher
];
@NgModule({
  declarations:[

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HomeComponent,
    EtudiantsComponent,
    AppComponent
  ],
  providers:[],
  bootstrap:[]
})
export class HomeModule{

}
