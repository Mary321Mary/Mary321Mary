import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isLoggedIn = false;
  errorMess = false;
  user: any = {};

  constructor(
    private httpClientService: HttpClientService
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
        this.errorMess = false;
        localStorage.setItem('token', data.accessToken);
        localStorage.setItem('user', JSON.stringify(data));
        location.reload();
      },
      error => {
        this.errorMess = true;
      }
    );
  }
}
