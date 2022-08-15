import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlldemandsComponent } from './alldemands.component';

describe('AlldemandsComponent', () => {
  let component: AlldemandsComponent;
  let fixture: ComponentFixture<AlldemandsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlldemandsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlldemandsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
