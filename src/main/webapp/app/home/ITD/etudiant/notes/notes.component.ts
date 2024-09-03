import { Component, inject, OnDestroy, OnInit, signal } from '@angular/core';
import { Account } from '../../../../core/auth/account.model';
import { AccountService } from '../../../../core/auth/account.service';
import { Subject, takeUntil } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'jhi-notes',
  standalone: true,
  imports: [],
  templateUrl: './notes.component.html',
  styleUrl: './notes.component.scss'
})
export class NotesComponent implements OnInit, OnDestroy {
   account = signal<Account | null>(null);

  private readonly destroy$ = new Subject<void>();

  protected accountService = inject(AccountService);
  private router = inject(Router);
  private notesService: any;
  private notes: any;

  ngOnInit(): void {
    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe(account => this.account.set(account));
  }

  login(): void {
    this.router.navigate(['/login']);
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }


 /* loadNotes(): void {
    this.notesService
      .getNotes()
      .pipe(takeUntil(this.destroy$))
      .subscribe(
        notes => this.notes.set(notes),
        error => console.error('Erreur lors du chargement des notes:', error)
      );
  }*/
}
