import {Component, inject} from '@angular/core';
import {CommonModule, AsyncPipe} from '@angular/common';
import {Product} from '../product';
import {CheckoutService} from '../checkout.service';
import {Observable, of} from 'rxjs';
import {WebSocketService} from '../services/websocket.service';
@Component({
  selector: 'app-checkout',
  imports: [CommonModule],
  template: `
    <section class="products">
      <table>
        <tbody>
          @for(product of checkoutProducts$ | async; track product.id) {
            <tr class="product">
              <td class="image">
                <img
                  [src]="product.image"
                  alt="Image of {{ product.name }}"
                />
              </td>
              <td class="text">{{product.name}}</td>
              <td class="number">€{{product.price}}</td>
              <td class="actions">
                <button (click)="deleteProduct(product.id)"><img src="assets/trash_can.svg"/></button>
              </td>
            </tr>
          } @empty {
            <tr class="empty"><td><img src="assets/scan_items.png"/></td></tr>
          }
        </tbody>
      </table>
    </section>
  `,
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent {
  public checkoutProducts$! : Observable<Product[]>;
  webSocketService = inject(WebSocketService);
  checkoutService = inject(CheckoutService);

  constructor() {
    this.checkoutProducts$ = this.checkoutService.getProducts();
    let stompClient = this.webSocketService.connect();
    stompClient.connect({}, (frame: any) => {
      stompClient.subscribe('/checkout/products', (products : any) => {
        console.log("Receiving data from socket");
        this.checkoutProducts$ = of(JSON.parse(products.body));
      })
    });
  }

  deleteProduct(id: number) {
    console.log(`Component - Deleting ${id}`);
    this.checkoutService.deleteProduct(id);
  }

}