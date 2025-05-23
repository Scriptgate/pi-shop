import {Component} from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
@Component({
  selector: 'app-root',
  imports: [RouterLink, RouterOutlet],
  template: `
    <main>
      <a [routerLink]="['/']">
      <header class="brand-name">
        <img class="brand-logo" src="/assets/logo.svg" alt="logo" aria-hidden="true" />
      </header>
      </a>
      <section class="menu">
        <a [routerLink]="['/checkout']">
          <h3>Checkout</h3>
        </a>
        |
        <a [routerLink]="['/manage']">
          <h3>Manage</h3>
        </a>
      </section>
      <section class="content">
        <router-outlet></router-outlet>
      </section>
    </main>
  `,
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'homes';
}
