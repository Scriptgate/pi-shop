import { Injectable, inject } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Product } from './product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class CheckoutService {

  private http = inject(HttpClient);
  url = '/backend/checkout';

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url);
  }
}