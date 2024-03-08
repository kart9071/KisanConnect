import { Component, OnInit } from '@angular/core';
import { Input, Dropdown, Collapse, initMDB } from 'mdb-ui-kit';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/service/register.service';
import { Register } from 'src/app/model/register.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user =new Register();
  msg='';

  constructor(private _registerService : RegisterService, private _router : Router) { }

  ngOnInit(): void {
    initMDB({ Input, Dropdown, Collapse });
  }

  registerUser()
  {
      this._registerService.registeruser(this.user).subscribe(
      data => {
        console.log("Registration Success");
        sessionStorage.setItem("username",this.user.username);
        this._router.navigate(['/registrationsuccess']);
      },
      error => {
        console.log("Registration Failed");
        console.log(error.error);
        this.msg = "User with "+this.user.email+" already exists !!!";
      }
    )
  }

}