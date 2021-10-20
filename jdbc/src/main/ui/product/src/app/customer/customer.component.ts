import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer, HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Customer = new Customer("", "", "", "", "", "");
  sumOfProducts: number = 0;
  idOrder: number = 0;
  error: string[] = [];

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.makeOrder().subscribe(
      response => {
        this.customer = response.customer;
        this.sumOfProducts = response.sum;
        this.idOrder = response.idOrder;
        localStorage.removeItem('idsOfProducts');
        localStorage.removeItem('count');
        localStorage.removeItem('customer');
      },
      error => {
        var array = [];
        for(var i = 0; i < error.error.length; i++){
          array.push(error.error[i].message);
        }
        alert(array);
        this.router.navigate(['/order']);
      }
    );
  }
}
