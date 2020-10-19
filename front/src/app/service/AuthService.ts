import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegistrationRequestPayload} from '../pages/registration/registrationRequestPayload';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient: HttpClient) {
  }

  signUp(registrationRequestPayload: RegistrationRequestPayload): Observable<any> {
    return this.httpClient.post('http://localhost:8080/auth/signup', registrationRequestPayload, {responseType: 'text'});
  }
}
