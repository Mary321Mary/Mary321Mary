import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Orders } from '../service/http-client.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  orders: Orders[] = [];

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getOrders().subscribe(
      response => {
        this.orders = response;
      }, err => {
        //alert(err.error.error);
        this.router.navigate(['/products']);
      }
    );
  }

}
