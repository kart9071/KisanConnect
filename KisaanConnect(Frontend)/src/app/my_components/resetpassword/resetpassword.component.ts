import { Component, OnInit } from '@angular/core';
import { ResetpasswordService } from 'src/app/service/resetpassword.service';
import { Login } from 'src/app/model/login.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']

})
export class ResetpasswordComponent implements OnInit {
  
  constructor(private _resetpasswordservice:ResetpasswordService, private _router:Router) { }
  ngOnInit(): void {
  }
  user = new Login();
  confirmPassword='';
  Otp ='';
  
  resetPassword(): void {
    if(this.user.password !== this.confirmPassword){
      console.log("check the password")
      window.alert("please match the password");
      return;
    }
    this._resetpasswordservice.resetPassword(this.user).subscribe(
      (response) => {
        console.log("reset success")
        this._router.navigate(['/login'])
      },
      (error) => {
        // Handle error (e.g., show error message)
      }
    );
  }

}
