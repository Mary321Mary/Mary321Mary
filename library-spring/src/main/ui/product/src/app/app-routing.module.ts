import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { EditComponent } from './edit/edit.component';
import { LoginComponent } from './login/login.component';
import { MycarsComponent } from './mycars/mycars.component';
import { ProductByIdComponent } from './product-by-id/product-by-id.component';
import { ProductComponent } from './product/product.component';
import { MybooksComponent } from './mybooks/mybooks.component';
import { EventsComponent } from './events/events.component';
import { IssuedComponent } from './issued/issued.component';
import { UpdateEventComponent } from './update-event/update-event.component';
import { ReaderComponent } from './reader/reader.component';

const routes: Routes = [
  { path:'books', component: ProductComponent},
  { path:'book', component: ProductByIdComponent},
  { path:'admin', component: AdminComponent},
  { path:'login', component: LoginComponent},
  { path:'mycars', component: MycarsComponent},
  { path:'edit', component: EditComponent},
  { path:'mybooks', component: MybooksComponent},
  { path:'events', component: EventsComponent},
  { path:'issued', component: IssuedComponent},
  { path:'update-event', component: UpdateEventComponent},
  { path:'reader', component: ReaderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
