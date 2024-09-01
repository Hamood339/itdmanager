import { Routes } from '@angular/router';

import { Authority } from 'app/config/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { errorRoute } from './layouts/error/error.route';

import HomeComponent from './home/ITD/home.component';
import NavbarComponent from './layouts/navbar/navbar.component';
import LoginComponent from './login/login.component';

import { AcceuilComponent } from './acceuil/acceuil.component';
import { EtudiantComponent } from './etudiant/etudiant.component';

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
    path: 'acceuil',
    component: AcceuilComponent,
    title: 'Acceuil',
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
