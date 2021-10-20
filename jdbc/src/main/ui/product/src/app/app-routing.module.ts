import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { BasketComponent } from './basket/basket.component';
import { CustomerComponent } from './customer/customer.component';
import { LoginComponent } from './login/login.component';
import { ProductByIdComponent } from './product-by-id/product-by-id.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  { path:'products', component: ProductComponent},
  { path:'order', component: BasketComponent},
  { path:'product', component: ProductByIdComponent},
  { path:'customer', component: CustomerComponent},
  { path:'admin', component: AdminComponent},
  { path:'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
