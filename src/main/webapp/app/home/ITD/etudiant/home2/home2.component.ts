import { Component, inject, OnDestroy, OnInit, signal } from '@angular/core';
import { NgIf } from '@angular/common';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { Account } from '../../../../core/auth/account.model';
import { Subject } from 'rxjs';
import { AccountService } from '../../../../core/auth/account.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'jhi-home2',
  standalone: true,
  imports: [
    NgIf,
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './home2.component.html',
  styleUrl: './home2.component.scss'
})
export class Home2Component implements OnInit, OnDestroy {
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
