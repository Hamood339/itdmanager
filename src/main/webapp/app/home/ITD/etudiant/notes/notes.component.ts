import { Component, inject, OnDestroy, OnInit, signal } from '@angular/core';
import { Account } from '../../../../core/auth/account.model';
import { AccountService } from '../../../../core/auth/account.service';
import { Subject, takeUntil } from 'rxjs';
import { Router } from '@angular/router';
import {FormsModule} from "@angular/forms";
<<<<<<< HEAD
import {NgForOf} from "@angular/common";
=======
import { NgForOf } from '@angular/common';
>>>>>>> f5c0d2dbebb29e6aa764dfbee5629ae581e0128a

@Component({
  selector: 'jhi-notes',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf
  ],
  templateUrl: './notes.component.html',
  styleUrl: './notes.component.scss'
})
export class NotesComponent implements OnInit, OnDestroy {
   account = signal<Account | null>(null);



  private readonly destroy$ = new Subject<void>();

  protected accountService = inject(AccountService);
  private router = inject(Router);
   notes: any;
  private notesService: any;
  note: any;
  matiere : any;
  etudiantId : any;

  ngOnInit(): void {
    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe(account => this.account.set(account));
  }

  login(): void {
    this.router.navigate(['/login']);
  }
  Notes(): void{
this.notesService.getNotes().subscribe((note: any)=>this.note= note)
    console.log("Erreur lors du chargement des notes");

  }

  getNotesByEtudiantId(): void {
    if (this.etudiantId) {
      this.notesService.getNotesByEtudiantId(this.etudiantId).subscribe((note: any) => this.notes = note)

      console.log("Erreur lors du chargement des notes de l'étudiant");
    }


    }


  getNoteByMatiere(): void {
    this.matiere
    {
      this.notesService.getNoteByMatiere(this.matiere).subscribe((note: any) => this.notes = note)

      console.log("Erreur lors du chargement de la note pour la matière");
    }
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }



}
