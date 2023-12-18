import { TestBed } from '@angular/core/testing';

import { SimplegridService } from './simplegrid.service'

describe('SimplegridService', () => {
  let service: SimplegridService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SimplegridService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
