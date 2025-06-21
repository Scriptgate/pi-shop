import {Component, inject} from '@angular/core';
import {CommonModule, AsyncPipe} from '@angular/common';
import {ProductComponent} from '../product/product.component';
import {Product} from '../product';
import {ProductService} from '../product.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
@Component({
  selector: 'app-home',
  imports: [CommonModule, ProductComponent, AsyncPipe],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  productService: ProductService = inject(ProductService);
  products$!: Observable<Product[]>;
  filteredProducts$!: Observable<Product[]>;
  constructor() {
    this.products$ = this.productService.getAllProducts();
    this.filteredProducts$ = this.products$;
  }
  filterProducts(text: string) {
    if (!text) {
      this.filteredProducts$ = this.products$;
      return;
    }
    this.filteredProducts$ = this.products$.pipe(map((products : Product[]) =>
      products.filter((product : Product) =>
        product?.name.toLowerCase().includes(text.toLowerCase())
      )
    ));
  }
}