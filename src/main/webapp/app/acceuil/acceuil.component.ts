import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'jhi-acceuil',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './acceuil.component.html',
  styleUrl: './acceuil.component.scss'
})
export class AcceuilComponent {

}
