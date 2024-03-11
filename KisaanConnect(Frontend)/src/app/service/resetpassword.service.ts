import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../model/login.model';

const NAV_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class ResetpasswordService {

  constructor(private _Http: HttpClient) { }

  resetPassword(user :Login): Observable<any> {
    console.log(user)
    return this._Http.post(`${NAV_URL}/send-otp`, user);
  }

  sendotp(otp: string): Observable<any> {
    return this._Http.post(`${NAV_URL}/verify-otp`, otp);
  }
}

