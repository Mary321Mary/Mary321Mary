import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Event } from '../service/http-client.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events!: Event[];
  employee = JSON.parse(localStorage.getItem('employee')!);

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getEventsByDateAfter().subscribe(
      response => {
        this.events = response;
        //alert(this.books[0].count);
        //this.pages = new Array(response.totalPages);
      },
    );
  }

  allEventsAfter(): void {
    this.httpClientService.getEventsByDateAfter().subscribe(
      response => this.events = response
    );
  }

  allEvents(): void {
    this.httpClientService.getEvents().subscribe(
      response => this.events = response
    );
  }

  updateEvent(eventId: number): void {
    localStorage.setItem('eventId', JSON.stringify(eventId));
    this.router.navigate(['/update-event']);
  }

  deleteEvent(eventId: number): void {
    localStorage.setItem('eventId', JSON.stringify(eventId));
    this.httpClientService.deleteBook().subscribe();
    this.router.navigate(['/events']);
  }

}
