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
  templateUrl: './details.component.html',
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