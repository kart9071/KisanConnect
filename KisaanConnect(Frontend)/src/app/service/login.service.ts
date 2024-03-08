import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from "rxjs/operators";
import { Login } from '../model/login.model'

const NAV_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  login = new Login();

  constructor(private _Http: HttpClient) { }

  public loginuser(login: Login) {
    return this._Http.post<any>(`${NAV_URL}/loginuser`, login).pipe(
      map(
        data => {
          sessionStorage.setItem('USER', login.username);
          sessionStorage.setItem('TOKEN', `Bearer ${data.token}`);
          return data;
        }
      )
    );
  }

}
