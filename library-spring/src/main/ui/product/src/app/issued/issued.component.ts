import { Component, OnInit } from '@angular/core';
import { HttpClientService, IssuedDto } from '../service/http-client.service';

@Component({
  selector: 'app-issued',
  templateUrl: './issued.component.html',
  styleUrls: ['./issued.component.css']
})
export class IssuedComponent implements OnInit {

  issueds!: IssuedDto[];

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(): void {
    this.httpClientService.findAllByDateReturnIsNull().subscribe(
      response => {
        this.issueds = response;
      },
    );
  }

  dateReturnIsNull(): void {
    this.httpClientService.findAllByDateReturnIsNull().subscribe(
      response => this.issueds = response
    );
  }

  allIssueds(): void {
    this.httpClientService.findAllIssued().subscribe(
      response => this.issueds = response
    );
  }

  saveId(idOfReader: number): void {
    localStorage.setItem('readerId', JSON.stringify(idOfReader));
  }

}
