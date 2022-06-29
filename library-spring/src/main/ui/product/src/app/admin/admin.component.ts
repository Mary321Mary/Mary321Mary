import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, User } from '../service/http-client.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  users: User[] = [];

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    // this.httpClientService.getUsers().subscribe(
    //   response => {
    //     this.users = response;
    //   }, err => {
    //     this.router.navigate(['/books']);
    //   }
    // );
  }

}
