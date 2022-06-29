import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Book, Publishing, Genre } from '../service/http-client.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  book: Book = new Book(-1, "", 0, 0, "", "", 0, new Publishing(-1, ""), new Genre(-1, ""), []);
  publishing!: Publishing[];
  genres!: Genre[];

  constructor(
    private httpClientService:HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getBook().subscribe(
      response => {
        this.book = response.book;
        this.genres = response.genres;
        this.publishing = response.publishing;
      },
    );
  }

  Submit() {
    //localStorage.setItem('book', JSON.stringify(this.book));
    if(this.book.id != -1){
      this.httpClientService.updateBook(this.book).subscribe();
    } else {
      this.httpClientService.addBook(this.book).subscribe();
    }
    this.router.navigate(['/books']);
  }

}
