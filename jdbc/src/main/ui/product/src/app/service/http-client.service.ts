import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Product{
  constructor(
    public id: number,
    public name: string,
    public quantity: string,
    public price: number
  ) {}
}

export class OrderAndSum{
  constructor(
    public productList: Product[],
    public sum: number
  ) {}
}

export class Customer {
  constructor(
    public name: string,
    public phone: string,
    public email: string,
		public cardNumber: string,
		public address: string,
		public comment: string
  ) {}
}

export class CustomerDto {
  constructor(
    public customer: Customer,
    public sum: number,
    public idOrder: number
  ) {}
}

export class User {
  constructor(
    public name: string,
    public email: string
  ) {}
}

export class Role {
  constructor(
    public name: string
  ) {}
}

export class Orders {
  constructor(
    public user: User,
    public phone: string,
    public address: string,
    public comment: string
  ) {}
}

export class JwtResponse {
  constructor(
	  public accessToken: string,
    public username: string,
    public roles: Role[]
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public getProducts() {
    return this.httpClient.get<Product[]>('http://localhost:8080/products');
  }

  public getProduct() {
    let idOfProduct = JSON.parse(localStorage.getItem('id')!)
    return this.httpClient.get<Product>('http://localhost:8080/products/' + idOfProduct);
  }

  public getBasket() {
    let idsOfProducts = JSON.parse(localStorage.getItem('idsOfProducts')!);
    if(idsOfProducts == null) {
      idsOfProducts = [];
    }
    return this.httpClient.post<OrderAndSum>('http://localhost:8080/order', idsOfProducts);
  }

  public makeOrder() {
    let idsOfProducts = JSON.parse(localStorage.getItem('idsOfProducts')!);
    if(idsOfProducts == null) {
      idsOfProducts = [];
    }
    let customer = JSON.parse(localStorage.getItem('customer')!);
    return this.httpClient.post<CustomerDto>('http://localhost:8080/order/makeOrder', {idsOfProducts, customer});
  }

  public getOrders() {
    return this.httpClient.get<Orders[]>('http://localhost:8080/order/getOrders');
  }

  public login(credentials: any) {
    return this.httpClient.post<JwtResponse>('http://localhost:8080/login', {
      username: credentials.username,
      password: credentials.password
    });
  }
}
