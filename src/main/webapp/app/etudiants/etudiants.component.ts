import { Component, inject, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  Validators, ɵElement
} from '@angular/forms';
import { setUiPort } from 'browser-sync/dist/options';
import { EtudiantsService } from './etudiants.service';
import { subscriptionLogsToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { Etudiant } from './etudiant.model';

@Component({
  selector: 'jhi-etudiants',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './etudiants.component.html',
  styleUrl: './etudiants.component.scss'
})
export class EtudiantsComponent implements OnInit{
   etudiant:FormGroup;
   constructor(private fb:FormBuilder) {
     this.etudiant=this.fb.group({
       id:[length],
       prenom:[''],
       nom:[''],
       adresse:[''],
       email:['', Validators.email]
     })


   }

   private etudiantsService =inject(EtudiantsService)
  ngOnInit() :void {

  }

  onSubmit(): void {
    if (this.etudiant.valid) {
      const etudiant: Etudiant = this.etudiant.value;
      this.etudiantsService.addEtudiant(etudiant).subscribe(
        response => {
          console.log('Étudiant ajouté:', response);
          this.etudiant.reset();
        },
        error => {
          console.error('Erreur lors de l\'ajout de l\'étudiant', error);
        }
      );
    }}
  protected readonly setUiPort = setUiPort;

   getEtudiant():void {
     this.etudiantsService.getEtudiant().subscribe((etudiant) =>this.etudiant=etudiant);
   }

   addEtudiant():void{
     this.etudiantsService.addEtudiant(this.etudiant).subscribe(etudiant=>this.etudiant)
   }
}
