import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Product} from '../product';
import {CheckoutService} from '../checkout.service';
import {Observable, of} from 'rxjs';
import {WebSocketService} from '../services/websocket.service';
import {map} from "rxjs/operators";

@Component({
    selector: 'app-checkout',
    imports: [CommonModule],
    template: `
        <section class="products">
            <div class="table-scroll">
                <table>
                    <tbody>
                        @for (product of checkoutProducts$ | async; track product.id) {
                            <tr class="product">
                                <td class="image">
                                    <img
                                            [src]="product.image"
                                            alt="Image of {{ product.name }}"
                                    />
                                </td>
                                <td class="text">{{ product.name.toUpperCase() }}</td>
                                <td class="number">&euro;&nbsp;{{ product.price }}</td>
                                <td class="actions">
                                    <button (click)="deleteProduct(product.id)"><img src="assets/trash_can.svg"/></button>
                                </td>
                            </tr>
                        } @empty {
                            <tr class="empty">
                                <td>
                                    <img src="{{ paymentImage }}" [ngClass]="{show: isPaying, hide: !isPaying}"/>
                                    <img src="assets/scan_items.png" [ngClass]="{show: !isPaying, hide: isPaying}"/>
                                </td>
                            </tr>
                        }
                    </tbody>
                </table>
            </div>
        </section>
        <footer class="payment actions">
            <button [disabled]="(checkoutProducts$ | async)?.length == 0" (click)="pay('cash')"><img src="assets/cash_payment_icon.svg"/></button>
            <button [disabled]="(checkoutProducts$ | async)?.length == 0" (click)="pay('card')"><img src="assets/card_payment_icon.svg"/></button>
            <div>&euro;&nbsp;{{ totalPrice$ | async }}</div>
        </footer>
    `,
    styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent {
    public checkoutProducts$!: Observable<Product[]>;
    public totalPrice$: Observable<number> = of(0)
    webSocketService = inject(WebSocketService);
    checkoutService = inject(CheckoutService);
    paymentImage = "";
    isPaying = false;

    constructor() {
        this.checkoutProducts$ = this.checkoutService.getProducts();
        let stompClient = this.webSocketService.connect();
        stompClient.connect({}, (frame: any) => {
            stompClient.subscribe('/checkout/products', (products: any) => {
                console.log("Receiving data from socket");
                this.checkoutProducts$ = of(JSON.parse(products.body));
                this.totalPrice$ = this.checkoutProducts$.pipe(
                    map(order => order.reduce((total, product) => total + product.price, 0))
                );
            })
        });
    }

    deleteProduct(id: number) {
        console.log(`Component - Deleting ${id}`);
        this.checkoutService.deleteProduct(id);
    }

    pay(method: string) {
        console.log(`Payment - ${method}`);
        this.checkoutService.pay(method);
        this.paymentImage = `assets/${method}_payment.gif`;
        this.isPaying = true;
        setTimeout(() => {
            this.isPaying = false;
            this.paymentImage = "";
        }, 5000);
    }
}