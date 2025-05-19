import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Product} from '../product';
import {ProductService} from '../product.service';
import {Observable} from 'rxjs';
import {WebSocketService} from '../services/websocket.service';
@Component({
  selector: 'app-checkout',
  imports: [CommonModule],
  template: `
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
          <tr *ngFor="let product of checkoutProducts">
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
        </tbody>
      </table>
    </section>
  `,
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent {
  public checkoutProducts : Product[] = [];

  webSocketService = inject(WebSocketService);

  constructor() {
    let stompClient = this.webSocketService.connect();
    stompClient.connect({}, (frame: any) => {
      stompClient.subscribe('/checkout/products', (products : any) => {
        console.log("Receiving data from socket");
        this.checkoutProducts = JSON.parse(products.body);
      })
    });
  }

}