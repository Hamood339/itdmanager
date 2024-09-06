import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'jhi-professeur',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './professeur.component.html',
  styleUrl: './professeur.component.scss'
})
export class ProfesseurComponent {

}
