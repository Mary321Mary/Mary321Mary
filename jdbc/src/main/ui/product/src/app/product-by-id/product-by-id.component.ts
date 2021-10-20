import { Component, OnInit } from '@angular/core';
import { HttpClientService, Product } from '../service/http-client.service';

@Component({
  selector: 'app-product-by-id',
  templateUrl: './product-by-id.component.html',
  styleUrls: ['./product-by-id.component.css']
})
export class ProductByIdComponent implements OnInit {

  product: Product = new Product(-1, "", "", -1);

  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit(): void {
    this.httpClientService.getProduct().subscribe(
      response => {this.product = response},
    );
  }

}
