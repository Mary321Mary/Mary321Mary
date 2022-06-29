import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { ProductByIdComponent } from './product-by-id/product-by-id.component';
import { FormsModule } from '@angular/forms';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { JwtInterceptor } from './jwt.interceptor';
import { MycarsComponent } from './mycars/mycars.component';
import { EditComponent } from './edit/edit.component';
import { MybooksComponent } from './mybooks/mybooks.component';
import { EventsComponent } from './events/events.component';
import { UpdateEventComponent } from './update-event/update-event.component';
import { IssuedComponent } from './issued/issued.component';
import { UpdateIssuedComponent } from './update-issued/update-issued.component';
import { ReaderComponent } from './reader/reader.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ProductByIdComponent,
    AdminComponent,
    LoginComponent,
    MycarsComponent,
    EditComponent,
    MybooksComponent,
    EventsComponent,
    UpdateEventComponent,
    IssuedComponent,
    UpdateIssuedComponent,
    ReaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
