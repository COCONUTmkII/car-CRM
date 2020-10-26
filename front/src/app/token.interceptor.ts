import {Injectable} from '@angular/core';
import {AuthService} from './service/AuthService';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {BehaviorSubject, Observable, throwError} from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {LoginResponsePayload} from './pages/login/loginResponsePayload';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptor implements HttpInterceptor{
  isTokenRefreshing = false;
  refreshTokenSubject: BehaviorSubject<any> = new BehaviorSubject<any>(null);

  constructor(
    public authService: AuthService
  ) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.authService.getJwtToken();
    if (token) {
      this.addToken(request, token);
    } else {
      return next.handle(request).pipe(catchError(error => {
        if (error instanceof HttpErrorResponse && error.status === 403) {
          return this.handleAuthErrors(request, next);
        } else {
          return throwError(error);
        }
      }));
    }
  }

  addToken(request: HttpRequest<any>, jwtToken: any) {
    return request.clone({
      headers: request.headers.set('Authorization', 'Bearer' + jwtToken)
    })
  }

  private handleAuthErrors(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (!this.isTokenRefreshing) {
      this.isTokenRefreshing = true;
      this.refreshTokenSubject.next(null);

      return this.authService.refreshToken().pipe(
        switchMap((refreshTokenResponse: LoginResponsePayload) => {
          this.isTokenRefreshing = false;
          this.refreshTokenSubject
            .next(refreshTokenResponse.authenticationToken);
          return next.handle(this.addToken(request, refreshTokenResponse.authenticationToken));
        })
      )
    }
  }
}
