import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './my_components/login/login.component';
import { RegisterComponent } from './my_components/register/register.component';
import { RegistrationsuccessComponent } from './my_components/registrationsuccess/registrationsuccess.component';
import { HomeComponent } from './my_components/home/home.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'login', component: LoginComponent },
  {path:'register', component: RegisterComponent},
  {path:'registrationsuccess', component: RegistrationsuccessComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
