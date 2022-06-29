import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Book } from '../service/http-client.service';

@Component({
  selector: 'app-mybooks',
  templateUrl: './mybooks.component.html',
  styleUrls: ['./mybooks.component.css']
})
export class MybooksComponent implements OnInit {

  books!: Book[];

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getBooking().subscribe(
      response => {
        this.books = response;
      },
    );
  }

  saveId(idOfBook: number): void {
    localStorage.setItem('idOfBook', JSON.stringify(idOfBook));
  }

  saveGenreId(idOfGenre: number): void {
    localStorage.setItem('idOfGenre', JSON.stringify(idOfGenre));
    localStorage.setItem('typeOfReq', 'Genre');
  }

  saveAuthors(idOfAuthor: number): void {
    localStorage.setItem('idOfAuthor', JSON.stringify(idOfAuthor));
    localStorage.setItem('typeOfReq', 'Author');
  }

  deleteBooking(idOfBook: number): void {
    localStorage.setItem('idOfBook', JSON.stringify(idOfBook));
    this.httpClientService.deleteBooking().subscribe();
    location.reload();
  }

}
