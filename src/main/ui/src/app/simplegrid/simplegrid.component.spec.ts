import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimplegridComponent } from './simplegrid.component';

describe('SimplegridComponent', () => {
  let component: SimplegridComponent;
  let fixture: ComponentFixture<SimplegridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SimplegridComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SimplegridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
