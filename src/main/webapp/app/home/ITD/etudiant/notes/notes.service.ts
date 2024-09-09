import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


interface Notes {
}

@Injectable({
  providedIn: 'root'
})
export class NotesService {
  private url="http://localhost:8080/api/notes"
  private urlEtude = "http://localhost:8080/api/etudiant/"
  private urlMatière = "http://localhost:8080/api/matiere/"
  private httpClient: any;


  constructor( private http:HttpClient) {}

  notes(): Observable<object> {
    return this.httpClient.get(this.url);
  }

  getNotesByEtudiantId(): Observable<object> {
    return this.httpClient.get(this.urlEtude);
  }
  getNoteByMatiere(): Observable<object> {
    return this.httpClient.get(this.urlMatière);
  }

}
