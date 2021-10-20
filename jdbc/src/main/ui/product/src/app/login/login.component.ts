import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isLoggedIn = false;
  user: any = {};

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    if (!!localStorage.getItem('token')) {
      this.isLoggedIn = true;
    }
  }
  
  onSubmit(): void {
    this.httpClientService.login(this.user).subscribe(
      data => {
        this.isLoggedIn = true;
        localStorage.setItem('token', data.accessToken);
        localStorage.setItem('user', JSON.stringify(data));
        location.reload();
      }
    );
  }
}
