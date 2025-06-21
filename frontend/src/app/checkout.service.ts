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

  deleteProduct(id: number): void {
    this.http.delete(`${this.url}/${id}`).subscribe(() =>
      console.log(`Deleted product with id: ${id}`)
    );
  }

  pay(method: string): void {
    const paymentData = new FormData();
    paymentData.append('method', method);

    this.http.post<Product>(`${this.url}/pay`, paymentData).subscribe();
  }

}