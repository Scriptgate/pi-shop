import {Component, Input} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Product} from '../product';
import {RouterModule} from '@angular/router';
@Component({
  selector: 'app-product',
  imports: [CommonModule, RouterModule],
  template: `
    <section class="product">
      <img
        class="product-image"
        [src]="product.image"
        alt="Image of {{ product.name }}"
      />
      <h2 class="product-heading">{{ product.name }}</h2>
      <h2 class="product-price">€{{ product.price }}</h2>
      <p class="product-barcode">{{ product.barcode }}</p>
      <a [routerLink]="['/details', product.id]">Details</a>
    </section>
  `,
  styleUrls: ['./product.component.css'],
})
export class ProductComponent {
  @Input() product!: Product;
}
