import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {RegistrationComponent} from './pages/registration/registration.component';
import {LoginComponent} from './pages/login/login.component';
import {MainComponent} from './pages/main/main.component';

const routes: Routes = [

  {path: 'registration', component: RegistrationComponent},
  {path: 'sign-in', component: LoginComponent},
  {path: 'main', component: MainComponent},
  {path: '**', redirectTo: 'sign-in' }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes, {useHash: false, onSameUrlNavigation: 'reload'}),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoute { }
