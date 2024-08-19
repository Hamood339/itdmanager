import { NgModule } from '@angular/core';
import HomeComponent from './home.component';
import { EtudiantsComponent } from '../etudiants/etudiants.component';
import { RouterModule, Routes } from '@angular/router';
import AppComponent from '../app.component';
import { BrowserModule } from '@angular/platform-browser';
import { CertificationsComponent } from '../certifications/certifications.component';
import { AcceuilComponent } from '../acceuil/acceuil.component';
import LoginComponent from '../login/login.component';
const routes: Routes = [
  { path: '', component: HomeComponent }, // Route pour le composant d'accueil
  { path: 'example', component: EtudiantsComponent },
  { path:'certifs',component:CertificationsComponent},
  { path:'acceuil',component:AcceuilComponent},
  {path:'login', component:LoginComponent}

];
@NgModule({
  declarations:[


  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HomeComponent,
    EtudiantsComponent,
    AppComponent,
    CertificationsComponent,
    AcceuilComponent,
    LoginComponent
  ],
  providers:[],
  bootstrap:[]
})
export class HomeModule{

}
