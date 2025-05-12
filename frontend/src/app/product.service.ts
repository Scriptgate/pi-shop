import { Injectable } from '@angular/core';
import {Product} from './product';
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  url = 'http://localhost:8080/backend/products';
  async getAllProducts(): Promise<Product[]> {
    const data = await fetch(this.url);
    return (await data.json()) ?? [];
  }
  async getProductById(id: number): Promise<Product | undefined> {
    const data = await fetch(`${this.url}/${id}`);
    return (await data.json()) ?? {};
  }
  submitApplication(firstName: string, lastName: string, email: string) {
    // tslint:disable-next-line
    console.log(firstName, lastName, email);
  }
}