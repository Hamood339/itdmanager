import { Routes } from '@angular/router';

import { Authority } from 'app/config/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { errorRoute } from './layouts/error/error.route';

import HomeComponent from './home/ITD/home.component';
import NavbarComponent from './layouts/navbar/navbar.component';
import LoginComponent from './login/login.component';
import { EtudiantComponent } from './home/ITD/etudiant/etudiant.component';
import { Home2Component } from './home/ITD/etudiant/home2/home2.component';
import { AdministrationComponent } from './home/ITD/administration/administration.component';
import { NotificationComponent } from './home/ITD/notification/notification.component';
import { NotesComponent } from './home/ITD/etudiant/notes/notes.component';

import { ProfesseurComponent } from './home/ITD/professeur/professeur.component';
import { CertificationsComponent } from './home/ITD/etudiant/certifications/certifications.component';




const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'home.title',
  },
  {
    path: '',
    component: NavbarComponent,
    outlet: 'navbar',
  },
  {
    path: 'acceuil',
    component: Home2Component,
    title: 'Acceuil',
  },
  {
    path: 'admini',
    component: AdministrationComponent,
    title: 'administration',
  },
  {
    path: 'notifs',
    component: NotificationComponent,
    title: 'Notifications',
  },
  {
    path: 'notes',
    component: NotesComponent,
    title: 'Notes',
  },
  {
    path: 'certifs',
    component:  CertificationsComponent,
    title: 'certificatons',
  },
  {
    path: 'profs',
    component: ProfesseurComponent,
    title: 'Professeur',
  },

  {
    path: 'admin',
    data: {
      authorities: [Authority.ADMIN],
    },
    canActivate: [UserRouteAccessService],
    loadChildren: () => import('./admin/admin.routes'),
  },
  {
    path: 'account',
    loadChildren: () => import('./account/account.route'),
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'login.title',
  },

  {
    path: 'student',
    component: EtudiantComponent,
    title: 'Espace Etudiant',
  },



  {
    path: '',
    loadChildren: () => import(`./entities/entity.routes`),
  },

  ...errorRoute,
];

export default routes;
