import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CertificationService {
  private apiUrl = "https://localhost:8080/api/certifs";
  constructor(private http: HttpClient) {
  }

  getCertifications(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);

  }
}
