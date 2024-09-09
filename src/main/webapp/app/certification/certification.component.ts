import {Component, OnInit} from '@angular/core';
import {CertificationService} from "./certification.service";

@Component({
  selector: 'jhi-certification',
  standalone: true,
  imports: [],
  templateUrl: './certification.component.html',
  styleUrl: './certification.component.scss'
})
export class CertificationComponent implements OnInit {
  certifications: any[] = [];

  constructor(private certificationService: CertificationService) { }

  ngOnInit(): void {
    this.certificationService.getCertifications().subscribe(data => {
      this.certifications = data;
    });
  }
}

