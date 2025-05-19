import {Component, inject} from '@angular/core';
import {CommonModule, AsyncPipe} from '@angular/common';
import {ProductService} from '../product.service';
import {Product} from '../product';
import {FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
@Component({
  selector: 'app-manage',
  imports: [CommonModule, ReactiveFormsModule, AsyncPipe],
  template: `
    <section class="product-apply">
      <h2 class="section-heading">Add Product</h2>
      <form [formGroup]="applyForm">
        <label for="name">Name</label>
        <input id="name" type="text" formControlName="name" />
        <label for="image">Image</label>
        <input id="image" type="file" class="file-input" (change)="onFileSelected($event)" #fileUpload/>
        <div class="file-upload">
          {{fileName || "No file uploaded yet."}}
          <button class="upload-button secondary" (click)="fileUpload.click()">
            Attach file
          </button>
        </div>
        <label for="type">Type</label>
        <input id="type" type="text" formControlName="type" />
        <label for="barcode">Barcode</label>
        <input id="barcode" type="text" formControlName="barcode" />
        <label for="price">Price</label>
        <input id="price" type="number" formControlName="price" />
        <button type="submit" class="primary" (click)="addProduct()">Add</button>
      </form>
    </section>
    <hr/>
    <section class="filter">
          <form>
            <input type="text" placeholder="Filter by name" #filter />
            <button class="secondary" type="button" (click)="filterProducts(filter.value)">Search</button>
          </form>
        </section>
    <section class="products">
      <table>
        <thead>
          <th></th>
          <th class="text">Name</th>
          <th class="number">Barcode</th>
          <th class="number">Price</th>
          <th></th>
        </thead>
        <tbody>
          @if (filteredProducts$ | async; as filteredProducts) {
            <tr *ngFor="let product of filteredProducts">
              <td>
                <img
                  [src]="product.image"
                  alt="Image of {{ product.name }}"
                />
              </td>
              <td class="text">{{product.name}}</td>
              <td class="number">{{product.barcode}}</td>
              <td class="number">{{product.price}}</td>
              <td class="actions">remove</td>
            </tr>
          }
        </tbody>
      </table>
    </section>
  `,
  styleUrls: ['./manage.component.css'],
})
export class ManageComponent {

  productService = inject(ProductService);

  file!: File
  fileName = ''

  applyForm = new FormGroup({
    name: new FormControl(''),
    type: new FormControl(''),
    barcode: new FormControl(''),
    price: new FormControl(0),
  });

  onFileSelected(event: any) {
    this.file = event.target.files[0];
    if (this.file) {
      this.fileName = this.file.name;
    }
  }

  addProduct() {
    console.log("Adding product");
    this.productService.addProduct(
      this.applyForm.value.name ?? '',
      this.file,
      this.applyForm.value.type ?? '',
      this.applyForm.value.barcode ?? '',
      this.applyForm.value.price ?? 0,
    );
  }
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