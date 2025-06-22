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
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.css'],
    standalone: true
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