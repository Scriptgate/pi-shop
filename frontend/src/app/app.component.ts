import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  template: `
    <main>
      <section class="content">
        <router-outlet></router-outlet>
      </section>
    </main>
  `,
  styleUrls: ['./app.component.css'],
  standalone: true
})
export class AppComponent {
  title = 'homes';
}
