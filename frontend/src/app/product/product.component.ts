import {Component, Input} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Product} from '../product';
import {RouterModule} from '@angular/router';
@Component({
  selector: 'app-product',
  imports: [CommonModule, RouterModule],
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent {
  @Input() product!: Product;
}
