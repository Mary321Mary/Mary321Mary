import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Book } from '../service/http-client.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  //pages: number[] = [];
  //page: number = 0;
  books!: Book[];
  name!: string;

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getBooks().subscribe(
      response => {
        this.books = response;
        //alert(this.books[0].count);
        //this.pages = new Array(response.totalPages);
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

  Submit() {
    localStorage.setItem('name', JSON.stringify(this.name));
    localStorage.setItem('typeOfReq', 'Name');
    location.reload();
  }

  // setPage(i: number){
  //   localStorage.setItem('page', JSON.stringify(i));
  //   this.router.navigate(['/books']);
  // }
}
