import { Component, OnInit } from '@angular/core';
import { HttpClientService, Genre } from './service/http-client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private roles: string[] = [];
  isLoggedIn = false;
  admin = false;
  employee = false;
  username: string = "Гость";
  genres!: Genre[];

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(): void {
    this.isLoggedIn = !!localStorage.getItem('token');
    if (this.isLoggedIn) {
      let user = JSON.parse(localStorage.getItem('user')!);
      //alert(user.roles);
      this.roles = user.roles;
      this.admin = this.roles.includes('admin');
      this.employee = this.roles.includes('employee');
      localStorage.setItem('admin', JSON.stringify(this.admin));
      localStorage.setItem('employee', JSON.stringify(this.employee));
      this.username = user.username;
    }
    this.httpClientService.getGenre().subscribe(
      response => {
        this.genres = response;
      },
    );
  }

  books(): void {
    localStorage.setItem('typeOfReq', 'Books');
  }

  addBook(): void {
    localStorage.setItem('idOfBook', JSON.stringify(-1));
    //this.router.navigate(['/edit']);
  }

  addEvent(): void {
    localStorage.setItem('eventId', JSON.stringify(-1));
    //this.router.navigate(['/edit']);
  }

  saveGenreId(idOfGenre: number): void {
    localStorage.setItem('idOfGenre', JSON.stringify(idOfGenre));
    localStorage.setItem('typeOfReq', 'Genre');
  }

  logout(): void {
    localStorage.clear();
  }
}
