import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginResponsePayload} from './loginResponsePayload';
import {LoginRequestPayload} from './loginRequestPayload';
import {AuthService} from '../../service/AuthService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isErrorDueLogin = false;
  loginForm: FormGroup;
  loginPayload: LoginRequestPayload;
  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.loginPayload = {
      nickname: '',
      password: ''
    }
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      nickname: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }

  login(): void {
    this.loginPayload.nickname = this.loginForm.get('nickname').value;
    this.loginPayload.password = this.loginForm.get('password').value;

    this.authService.login(this.loginPayload).subscribe(data => {
      if (data) {
        this.isErrorDueLogin = false;
        this.router.navigateByUrl('/main');
      } else {
        this.isErrorDueLogin = true;
      }
    });
  }



}
