import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[] = [];
  isLoggedIn = false;
  admin = false;
  username: string = "Guest";

  constructor(private router: Router) { 

  }

  ngOnInit(): void {
    this.isLoggedIn = !!localStorage.getItem('token');
    if (this.isLoggedIn) {
      let user = JSON.parse(localStorage.getItem('user')!);
      this.roles = user.roles;
      this.admin = this.roles.includes('ROLE_ADMIN');
      this.username = user.username;

      let count = JSON.parse(localStorage.getItem('count')!);
      if (count == null) {
        count = 0;
      }
      const element = document.getElementById('count')!;
      element.innerHTML = count;
    }
  }

  GoToProducts(): void {
    this.router.navigate(['/products']);
  }

  logout(): void {
    localStorage.clear();
  }
}
