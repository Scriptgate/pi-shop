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
  templateUrl: './manage.component.html',
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