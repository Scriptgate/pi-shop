import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from '../product.service';
import {Product} from '../product';
import {FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';
@Component({
  selector: 'app-details',
  imports: [CommonModule, ReactiveFormsModule],
  template: `
    <article>
      <img
        class="product-image"
        [src]="product?.image"
        alt="Image of {{ product?.name }}"
        crossorigin
      />
      <section class="product-description">
        <h2 class="product-heading">{{ product?.name }}</h2>
        <p class="product-barcode">{{ product?.barcode }}</p>
      </section>
      <section class="product-features">
        <h2 class="section-heading">About this product</h2>
        <ul>
          <li>Type: {{ product?.type }}</li>
          <li>price: {{ product?.price }}</li>
        </ul>
      </section>
      <section class="product-apply">
        <h2 class="section-heading">Apply now to buy this</h2>
        <form [formGroup]="applyForm" (submit)="submitApplication()">
          <label for="first-name">First Name</label>
          <input id="first-name" type="text" formControlName="firstName" />
          <label for="last-name">Last Name</label>
          <input id="last-name" type="text" formControlName="lastName" />
          <label for="email">Email</label>
          <input id="email" type="email" formControlName="email" />
          <button type="submit" class="primary">Apply now</button>
        </form>
      </section>
    </article>
  `,
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  productService = inject(ProductService);
  product: Product | undefined;
  applyForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
  });
  constructor() {
    const productId = parseInt(this.route.snapshot.params['id'], 10);
    this.productService.getProductById(productId).then((product) => {
      this.product = product;
    });
  }
  submitApplication() {
    this.productService.submitApplication(
      this.applyForm.value.firstName ?? '',
      this.applyForm.value.lastName ?? '',
      this.applyForm.value.email ?? '',
    );
  }
}