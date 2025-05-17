import {Component, inject} from '@angular/core';
import {CommonModule, AsyncPipe} from '@angular/common';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from '../product.service';
import {Product} from '../product';
import {FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-details',
  imports: [CommonModule, ReactiveFormsModule, AsyncPipe],
  template: `
    <article>
      @if (product$ | async; as product) {
        <img
          class="product-image"
          [src]="product.image"
          alt="Image of {{ product.name }}"
        />
        <section class="product-description">
          <h2 class="product-heading">{{ product.name }}</h2>
          <p class="product-barcode">{{ product.barcode }}</p>
        </section>
        <section class="product-features">
          <h2 class="section-heading">About this product</h2>
          <ul>
            <li>Type: {{ product.type }}</li>
            <li>Price: €{{ product.price }}</li>
          </ul>
        </section>
      }
    </article>
  `,
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  productService = inject(ProductService);
  product$!: Observable<Product>;
  constructor() {
    const productId = parseInt(this.route.snapshot.params['id'], 10);
    this.product$ = this.productService.getProductById(productId);
  }
}