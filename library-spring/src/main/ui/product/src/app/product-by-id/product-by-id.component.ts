import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Book, Publishing, Genre, Author } from '../service/http-client.service';

@Component({
  selector: 'app-product-by-id',
  templateUrl: './product-by-id.component.html',
  styleUrls: ['./product-by-id.component.css']
})
export class ProductByIdComponent implements OnInit {

  book: Book = new Book(-1, "", 0, 0, "", "", 0, new Publishing(-1, ""), new Genre(-1, ""), []);
  employee = JSON.parse(localStorage.getItem('employee')!);

  constructor(
    private httpClientService:HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getBook().subscribe(
      response => {this.book = response.book},
    );
  }

  updateBook(): void {
    //   this.router.navigate(['/edit']);
  }

  deleteBook(): void {
    this.httpClientService.deleteBook().subscribe();
    this.router.navigate(['/books']);
  }

  saveGenreId(idOfGenre: number): void {
    localStorage.setItem('idOfGenre', JSON.stringify(idOfGenre));
    localStorage.setItem('typeOfReq', 'Genre');
  }

  saveAuthors(idOfAuthor: number): void {
    localStorage.setItem('idOfAuthor', JSON.stringify(idOfAuthor));
    localStorage.setItem('typeOfReq', 'Author');
  }

  addBooking(): void {
    this.httpClientService.addBooking().subscribe();
    location.reload();
  }

}
