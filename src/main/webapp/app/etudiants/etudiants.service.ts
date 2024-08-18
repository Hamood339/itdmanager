import { Injectable } from '@angular/core';
import { HttpClient, HttpContext, HttpEvent, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

class Etudiant {
}

@Injectable({
  providedIn: 'root'
})
export class EtudiantsService {
  url:any

  constructor(private httpClient:HttpClient) {
    this.url='http://localhost:8080/api/etudiant';
  }

  getEtudiant():Observable<any>{
    return this.httpClient.get(this.url)
  }

  addEtudiant(etudiant:Etudiant):Observable<Etudiant>{
    return this.httpClient.post<Etudiant>(this.url, etudiant)
  }



}
