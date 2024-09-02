import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private apiUrl = 'api/notifications'; // Adjust this to match your backend API

  constructor(private http: HttpClient) {}

  sendSMS(phoneNumber: string, message: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/sms`, { phoneNumber, message });
  }

  sendEmail(email: string, message: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/email`, { email, message });
  }
}

