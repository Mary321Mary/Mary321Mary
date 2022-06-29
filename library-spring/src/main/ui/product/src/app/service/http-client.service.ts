import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Book{
  constructor(
    public id: number,
    public name: string,
    public year: number,
    public pages: number,
    public description: string,
    public image: string,
    public count: number,
    public publishing: Publishing,
    public genre: Genre,
    public authors: Author[]
  ) {}
}

export class BookDto{
  constructor(
    public book: Book,
    public publishing: Publishing[],
    public genres: Genre[]
  ) {}
}

export class Author{
  constructor(
    public id: number,
    public fio: string
  ) {}
}

export class Employee{
  constructor(
    public id: number,
    public fio: string
  ) {}
}

export class EventDto{
  constructor(
    public employees: Employee[],
    public eventDto: Event
  ) {}
}

export class Event{
  constructor(
    public id: number,
    public name: string,
    public employee: string,
    public date: Date
  ) {}
}

export class Genre{
  constructor(
    public id: number,
    public name: string
  ) {}
}

export class Publishing{
  constructor(
    public id: number,
    public name: string
  ) {}
}

export class ReaderDto{
  constructor(
    public id: number,
    public fio: string,
    public phone: string,
    public address: string,
    public birthday: Date
  ) {}
}

export class IssuedDto{
  constructor(
    public id: number,
    public book: Book,
    public readerDto: ReaderDto,
    public employee: string,
    public dateIss: Date,
    public dateReturn: Date
  ) {}
}

// export class Car{
//   constructor(
//     public id: number,
//     public name: string,
//     public model: string,
//     public generation: string,
//     public mileage: string,
//     public engine: string,
//     public price: number
//   ) {}
// }

// export class CarCriteria{
//   constructor(
//     public model: string,
//     public generation: string,
//     public mileage: string,
//     public engine: string,
//     public priceFrom: number,
//     public priceTo: number,
//     public sort: string
//   ) {}
// }

// export class Criterias{
//   constructor(
//     public cars: Car[],
//     public carsModels: string[],
//     public carsGenerations: string[],
//     public carsMileages: string[],
//     public carsEngines: string[],
//     public totalPages: number
//   ) {}
// }

export class User {
  constructor(
    public username: string,
    public role: string
  ) {}
}

export class Role {
  constructor(
    public name: string
  ) {}
}

export class JwtResponse {
  constructor(
	  public accessToken: string,
    public username: string,
    public roles: Role[]
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public login(credentials: any) {
    return this.httpClient.post<JwtResponse>('http://localhost:8080/login', {
      username: credentials.username,
      password: credentials.password
    });
  }

  public getBooks() {
    let typeOfReq = localStorage.getItem('typeOfReq');
    //alert(typeOfReq);
    if(typeOfReq == 'Genre') {
      let idOfGenre = JSON.parse(localStorage.getItem('idOfGenre')!);
      return this.httpClient.get<Book[]>('http://localhost:8080/books/genre/' + idOfGenre);
    } else if(typeOfReq == 'Author') {
      let idOfAuthor = JSON.parse(localStorage.getItem('idOfAuthor')!);
      return this.httpClient.get<Book[]>('http://localhost:8080/books/author/' + idOfAuthor);
    } else if(typeOfReq == 'Name') {
      let name = JSON.parse(localStorage.getItem('name')!);
      return this.httpClient.get<Book[]>('http://localhost:8080/books/name/' + name);
    } else {
      return this.httpClient.get<Book[]>('http://localhost:8080/books');
    }
  }

  // public getBooksByGenre() {
  //   /*let isDeleted = JSON.parse(localStorage.getItem('admin')!);
  //   let page = JSON.parse(localStorage.getItem('page')!);
  //   let carCriteria = JSON.parse(localStorage.getItem('CarCriteria')!);
  //   if(carCriteria == null) {
  //     carCriteria = new CarCriteria("", "", "", "", 0, 50000, "asc");
  //   }
  //   return this.httpClient.post<Criterias>('http://localhost:8080/car/all', {
  //     isDeleted: isDeleted,
  //     page: page,
  //     carCriteria: carCriteria
  //   });*/
  //   let idOfGenre = JSON.parse(localStorage.getItem('idOfGenre')!);
  //   return this.httpClient.get<Book[]>('http://localhost:8080/books/genre/' + idOfGenre);
  // }

  public getBooksByPublishing(publishing: number) {
    return this.httpClient.get<Book[]>('http://localhost:8080/books/publishing/' + publishing);
  }

  // public getBooksByName(name: string) {
  //   return this.httpClient.get<Book[]>('http://localhost:8080/books/name/' + name);
  // }

  // public getBooksByAuthor(author: number) {
  //   return this.httpClient.get<Book[]>('http://localhost:8080/books/author/' + author);
  // }

  public getBook() {
    let idOfBook = JSON.parse(localStorage.getItem('idOfBook')!);
    return this.httpClient.get<BookDto>('http://localhost:8080/books/' + idOfBook);
  }

  public addBook(book: Book) {
    return this.httpClient.post('http://localhost:8080/books', book);
  }

  public updateBook(book: Book) {
    return this.httpClient.put('http://localhost:8080/books', book);
  }

  public deleteBook() {
    let idOfBook = JSON.parse(localStorage.getItem('idOfBook')!);
    return this.httpClient.delete('http://localhost:8080/books/' + idOfBook);
  }

  public addBooking() {
    let user = JSON.parse(localStorage.getItem('user')!);
    let bookId = JSON.parse(localStorage.getItem('idOfBook')!);
    let username = user.username;
    return this.httpClient.post('http://localhost:8080/books/booking', {username, bookId});
  }

  public deleteBooking() {
    let user = JSON.parse(localStorage.getItem('user')!);
    let bookId = JSON.parse(localStorage.getItem('idOfBook')!);
    return this.httpClient.delete('http://localhost:8080/books/' + user.username + '/' + bookId);
  }

  public getBooking() {
    let user = JSON.parse(localStorage.getItem('user')!);
    return this.httpClient.get<Book[]>('http://localhost:8080/books/booking/' + user.username);
  }

  public getAuthors() {
    return this.httpClient.get<Author[]>('http://localhost:8080/authors');
  }

  public getAuthorsByName(name: string) {
    return this.httpClient.get<Author[]>('http://localhost:8080/authors/' + name);
  }

  // public getUsers() {
  //   return this.httpClient.get<User[]>('http://localhost:8080/user');
  // }

  public getEvents() {
    return this.httpClient.get<Event[]>('http://localhost:8080/events');
  }

  public getEventsByDateAfter() {
    return this.httpClient.get<Event[]>('http://localhost:8080/events/all');
  }

  public findEventById() {
    let eventId = JSON.parse(localStorage.getItem('eventId')!);
    return this.httpClient.get<EventDto>('http://localhost:8080/events/' + eventId);
  }

  public findEventsByNameContaining(name: string) {
    return this.httpClient.get<Event[]>('http://localhost:8080/events/name/' + name);
  }

  public findEventsByEmployeeId() {
    let employeeId = JSON.parse(localStorage.getItem('employeeId')!);
    return this.httpClient.get<Event[]>('http://localhost:8080/events/employee/' + employeeId);
  }

  public createEvent(event: Event) {
    return this.httpClient.post('http://localhost:8080/events', event);
  }

  public updateEvent(event: Event) {
    return this.httpClient.put('http://localhost:8080/events', event);
  }

  public deleteEventById() {
    let eventId = JSON.parse(localStorage.getItem('eventId')!);
    return this.httpClient.delete('http://localhost:8080/events/' + eventId);
  }

  public getGenre() {
    return this.httpClient.get<Genre[]>('http://localhost:8080/genre');
  }

  public findReaderByUsername() {
    let user = JSON.parse(localStorage.getItem('user')!);
    return this.httpClient.get<ReaderDto>('http://localhost:8080/readers/username' + user.username);
  }

  public findReaderById() {
    let readerId = JSON.parse(localStorage.getItem('readerId')!);
    return this.httpClient.get<ReaderDto>('http://localhost:8080/readers/' + readerId);
  }

  public createReader(reader: ReaderDto) {
    return this.httpClient.post('http://localhost:8080/readers', reader);
  }

  public updateReader(reader: ReaderDto) {
    return this.httpClient.put('http://localhost:8080/readers', reader);
  }

  public deleteReaderById() {
    let readerId = JSON.parse(localStorage.getItem('readerId')!);
    return this.httpClient.delete('http://localhost:8080/readers/' + readerId);
  }

  public findAllIssued() {
    return this.httpClient.get<IssuedDto[]>('http://localhost:8080/issued');
  }

  public findAllByDateReturnIsNull() {
    return this.httpClient.get<IssuedDto[]>('http://localhost:8080/issued/all');
  }

  public findIssuedByBookId() {
    let issuedId = JSON.parse(localStorage.getItem('issuedId')!);
    return this.httpClient.get<IssuedDto[]>('http://localhost:8080/issued/book/' + issuedId);
  }

  public findIssuedByReaderId() {
    let readerId = JSON.parse(localStorage.getItem('readerId')!);
    return this.httpClient.get<IssuedDto[]>('http://localhost:8080/issued/reader/' + readerId);
  }

  public findIssuedByEmployeeId() {
    let employeeId = JSON.parse(localStorage.getItem('employeeId')!);
    return this.httpClient.get<IssuedDto[]>('http://localhost:8080/issued/employee/' + employeeId);
  }

  public createIssued(issued: IssuedDto) {
    return this.httpClient.post('http://localhost:8080/issued', issued);
  }

  public closeIssued(issued: IssuedDto) {
    return this.httpClient.put('http://localhost:8080/issued', issued);
  }

}
