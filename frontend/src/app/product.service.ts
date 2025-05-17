import { Injectable, inject } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Product } from './product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class ProductService {

  private http = inject(HttpClient);
  url = 'http://localhost:8080/backend/products';

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url);
  }
  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.url}/${id}`);
  }
  addProduct(name: string, image: File, type: string, price: number) {
    const productData = new FormData();
    productData.append('name', name);
    productData.append('image', image, image.name);
    productData.append('type', type);
    productData.append('price', `${price}`);

    this.http.post<Product>(`${this.url}/create`, productData).subscribe((product: Product) => {
      console.log('Updated product:', product);
    });
  }
}