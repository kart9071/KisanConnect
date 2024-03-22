import { Injectable } from '@angular/core';
import { ItemDetail } from '../model/item-detail.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


const NAV_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})


export class ItemDetailService {

  constructor(private _Http: HttpClient) {}

  sendProductDetail(product: ItemDetail):Observable<any>{
    console.log(product);
    return this._Http.post(`${NAV_URL}/products`, product);
  }

  getProductDetails():Observable<any>{
    return this._Http.get(`${NAV_URL}/products/details`);
  }
}
