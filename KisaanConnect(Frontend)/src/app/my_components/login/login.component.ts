import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Input, Dropdown, Collapse, initMDB } from 'mdb-ui-kit';
import { Login } from 'src/app/model/login.model';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  ngOnInit(): void {
    initMDB({ Input, Dropdown, Collapse });
  }
  
  user =new Login();
  msg = '';

  constructor(private _loginservice:LoginService, private _router:Router ) { }

  

  loginUser()
  {
      this._loginservice.loginuser(this.user).subscribe(
        (data: any) => {

          if(data.id){
            window.alert("login sussessfull....!");
            this._router.navigate(['']);
           } else
           {
            window.alert("Sorry! You are not Approved !!!");
           }

          console.log(data);
          console.log("Response Received");
          
        },
        (error: { error: any; }) => {
          console.log(error.error);
          this.msg="Bad credentials, please enter valid credentials !!!";
        }
      )
  }

}
