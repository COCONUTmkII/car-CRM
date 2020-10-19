import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RegistrationRequestPayload} from './registrationRequestPayload';
import {AuthService} from '../../service/AuthService';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  signUpForm: FormGroup;
  registrationRequest: RegistrationRequestPayload;
  constructor(
    private authService: AuthService
  ) {
    this.registrationRequest = {
      email: '',
      name: '',
      nickname: '',
      password: '',
      patronymic: '',
      repeatPassword: '',
      surname: '',
      telephone: ''
    }
  }

  ngOnInit(): void {
    this.signUpForm = new FormGroup({
      nickname: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      repeatPassword: new FormControl('', Validators.required),
      email: new FormControl('', Validators.email),
      telephone: new FormControl('', Validators.required),
      name: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      patronymic: new FormControl('')
    });
  }

  signUp(): void {
    this.registrationRequest.nickname = this.signUpForm.get('nickname').value;
    this.registrationRequest.password = this.signUpForm.get('password').value;
    this.registrationRequest.repeatPassword = this.signUpForm.get('repeatPassword').value;
    this.registrationRequest.email = this.signUpForm.get('email').value;
    this.registrationRequest.telephone = this.signUpForm.get('telephone').value;
    this.registrationRequest.name = this.signUpForm.get('name').value;
    this.registrationRequest.surname = this.signUpForm.get('surname').value;
    this.registrationRequest.patronymic = this.signUpForm.get('patronymic').value;

    this.authService.signUp(this.registrationRequest)
      .subscribe(data => {
        console.log(data);
      })
  }
}
