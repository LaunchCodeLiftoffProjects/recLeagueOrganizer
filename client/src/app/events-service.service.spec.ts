import { TestBed } from '@angular/core/testing';

import { EventsServiceService } from './events-service.service';

describe('EventsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EventsServiceService = TestBed.get(EventsServiceService);
    expect(service).toBeTruthy();
  });
});
