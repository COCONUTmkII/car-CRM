import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegistrationRequestPayload} from '../pages/registration/registrationRequestPayload';
import {Observable} from 'rxjs';
import {LoginRequestPayload} from '../pages/login/loginRequestPayload';
import {LoginResponsePayload} from '../pages/login/loginResponsePayload';
import {LocalStorageService} from 'ngx-webstorage';
import {map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient: HttpClient, private localstorage: LocalStorageService) {
  }

  signUp(registrationRequestPayload: RegistrationRequestPayload): Observable<any> {
    return this.httpClient.post('http://localhost:8080/auth/signup', registrationRequestPayload, {responseType: 'text'});
  }

  login(loginRequestPayload: LoginRequestPayload): Observable<boolean> {
    return this.httpClient.post<LoginResponsePayload>('http://localhost:8080/auth/login', loginRequestPayload)
      .pipe(map(data => {
        this.localstorage.store('authenticationToken', data.authenticationToken);
        this.localstorage.store('nickname', data.nickname);
        this.localstorage.store('refreshToken', data.refreshToken);
        this.localstorage.store('expiresAt', data.expiresAt);

        return true;
      }))
  }

  getJwtToken() {
    return this.localstorage.retrieve('authenticationToken');
  }

  refreshToken() {
    const refreshTokenPayload = {
      refreshToken: this.getRefreshToken(),
      nickname: this.getNickname(),
    }
    return this.httpClient.post<LoginResponsePayload>('http://localhost:8080/auth/refreshToken', refreshTokenPayload)
               .pipe(tap(response => {
                 this.localstorage.store('authenticationToken', response.authenticationToken);
                 this.localstorage.store('expiresAt', response.expiresAt);
               }))
  }

  private getRefreshToken() {
    return this.localstorage.retrieve('authenticationToken');
  }

  private getNickname() {
    return this.localstorage.retrieve('nickname');
  }
}
