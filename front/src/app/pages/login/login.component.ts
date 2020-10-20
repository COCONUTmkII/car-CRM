import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginResponsePayload} from './loginResponsePayload';
import {LoginRequestPayload} from './loginRequestPayload';
import {AuthService} from '../../service/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginPayload: LoginRequestPayload;
  constructor(
    private authService: AuthService
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
      console.log('Login successful');
    });
  }



}
