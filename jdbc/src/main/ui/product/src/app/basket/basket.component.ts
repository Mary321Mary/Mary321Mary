import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer, HttpClientService, Product } from '../service/http-client.service';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {

  products: Product[] = [];
  sumOfProducts: number = 0;
  customer!: Customer;

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getBasket().subscribe(
      response => {
        this.products = response.productList;
        this.sumOfProducts = response.sum;
      },
    );
    let customer = JSON.parse(localStorage.getItem('customer')!);
    if(customer == null) {
      this.customer = new Customer("", "", "", "", "", "");
    } else {
      this.customer = customer;
    }
  }

  CleanBasket(): void {
    localStorage.setItem('idsOfProducts', JSON.stringify([]));
    this.httpClientService.getBasket().subscribe(
      response => {
        this.products = response.productList;
        this.sumOfProducts = response.sum;
      },
    );
    const element = document.getElementById('count')!;
    element.innerHTML = "0";
    localStorage.setItem('count', JSON.stringify(0));
  }

  Submit() {
    localStorage.setItem('customer', JSON.stringify(this.customer));
    this.router.navigate(['/customer']);
  }

  SaveCustomer(): void {
    localStorage.setItem('customer', JSON.stringify(this.customer));
  }
}
