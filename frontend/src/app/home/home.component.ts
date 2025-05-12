import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductComponent} from '../product/product.component';
import {Product} from '../product';
import {ProductService} from '../product.service';
@Component({
  selector: 'app-home',
  imports: [CommonModule, ProductComponent],
  template: `
    <section>
      <form>
        <input type="text" placeholder="Filter by name" #filter />
        <button class="primary" type="button" (click)="filterResults(filter.value)">Search</button>
      </form>
    </section>
    <section class="results">
      <app-product
        *ngFor="let product of filteredProducts"
        [product]="product"
      ></app-product>
    </section>
  `,
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  products: Product[] = [];
  productService: ProductService = inject(ProductService);
  filteredProducts: Product[] = [];
  constructor() {
    this.productService.getAllProducts().then((products: Product[]) => {
      this.products = products;
      this.filteredProducts = products;
    });
  }
  filterResults(text: string) {
    if (!text) {
      this.filteredProducts = this.products;
      return;
    }
    this.filteredProducts = this.products.filter((product) =>
      product?.name.toLowerCase().includes(text.toLowerCase()),
    );
  }
}