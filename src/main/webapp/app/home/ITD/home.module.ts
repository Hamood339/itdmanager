import { NgModule } from '@angular/core';
import HomeComponent from './home.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import LoginComponent from '../../login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent }, // Route pour le composant d'accueil
  {path:'login', component:LoginComponent}
];
@NgModule({
  declarations:[


  ],
  imports: [
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
