import { Component, OnInit } from '@angular/core';
import { HttpClientService, Product } from '../service/http-client.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[] = [];

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(): void {
    this.httpClientService.getProducts().subscribe(
      response => {this.products = response},
    );
  }

  addToBasket(idOfproduct: number): void {
    let idsOfProducts = JSON.parse(localStorage.getItem('idsOfProducts')!);
    if(idsOfProducts == null) {
      idsOfProducts = [];
    }
    idsOfProducts.push(idOfproduct);
    localStorage.setItem('idsOfProducts', JSON.stringify(idsOfProducts));

    let count = JSON.parse(localStorage.getItem('count')!);
    count++;
    const element = document.getElementById('count')!;
    element.innerHTML = count;
    localStorage.setItem('count', JSON.stringify(count));
  }

  description(idOfproduct: number): void {
    localStorage.setItem('id', JSON.stringify(idOfproduct));
  }
}
