import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateIssuedComponent } from './update-issued.component';

describe('UpdateIssuedComponent', () => {
  let component: UpdateIssuedComponent;
  let fixture: ComponentFixture<UpdateIssuedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateIssuedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateIssuedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
