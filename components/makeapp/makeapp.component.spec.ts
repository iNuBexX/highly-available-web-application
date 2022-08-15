import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeappComponent } from './makeapp.component';

describe('MakeappComponent', () => {
  let component: MakeappComponent;
  let fixture: ComponentFixture<MakeappComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MakeappComponent],
    }).compileComponents();
  });
  beforeEach(() => {
    fixture = TestBed.createComponent(MakeappComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
