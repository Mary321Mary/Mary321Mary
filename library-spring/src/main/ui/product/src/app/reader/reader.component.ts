import { Component, OnInit } from '@angular/core';
import { HttpClientService, ReaderDto } from '../service/http-client.service';

@Component({
  selector: 'app-reader',
  templateUrl: './reader.component.html',
  styleUrls: ['./reader.component.css']
})
export class ReaderComponent implements OnInit {

  reader!: ReaderDto;

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(): void {
    this.httpClientService.findReaderById().subscribe(
      response => {
        this.reader = response;
      },
    );
  }

}
