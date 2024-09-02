import { Component, inject, OnDestroy, OnInit, signal } from '@angular/core';
import { Account } from '../../../core/auth/account.model';
import { AccountService } from '../../../core/auth/account.service';
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



}
