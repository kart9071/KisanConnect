import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Resetpassword } from '../model/resetpassword.model';


const NAV_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class ResetpasswordService {

  constructor(private _Http: HttpClient) { }

  submitEmail(user:Resetpassword) {
    return this._Http.post<any>(`${NAV_URL}/send-otp`, user);
}

submitOtp(user:Resetpassword) {
  return this._Http.post<any>(`${NAV_URL}/verify-otp`, user);
}

resetpassword(user:Resetpassword) {
    return this._Http.post<any>(`${NAV_URL}/submit-NewPassword`, user)
}


}

