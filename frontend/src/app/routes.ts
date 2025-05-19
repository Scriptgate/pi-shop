import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {DetailsComponent} from './details/details.component';
import {ManageComponent} from './manage/manage.component';
import {CheckoutComponent} from './checkout/checkout.component';
const routeConfig: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Home | PiShop',
  },
  {
    path: 'details/:id',
    component: DetailsComponent,
    title: 'Product | PiShop',
  },
  {
    path: 'manage',
    component: ManageComponent,
    title: 'Manage | PiShop'
  },
  {
    path: 'checkout',
    component: CheckoutComponent,
    title: 'Checkout | PiShop'
  }
];
export default routeConfig;