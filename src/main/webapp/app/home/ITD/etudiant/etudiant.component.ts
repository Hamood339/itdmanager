import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'jhi-etudiant',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './etudiant.component.html',
  styleUrl: './etudiant.component.scss'
})
export class EtudiantComponent {

}
