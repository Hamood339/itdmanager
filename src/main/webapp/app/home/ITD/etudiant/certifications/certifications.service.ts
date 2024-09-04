import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Certifications } from './certifications.model';


@Injectable({
  providedIn: 'root'
})
export class CertificationsService {
  private apiUrl = 'https://localhost:8080/api/certifs'

  constructor(private http: HttpClient) { }

  getCertifications(): Observable<Certifications[]> {
    return this.http.get<Certifications[]>(this.apiUrl);
  }
}
