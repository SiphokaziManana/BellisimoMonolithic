/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ClothingServiceService } from './clothing.service';

describe('ClothingServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClothingServiceService]
    });
  });

  it('should ...', inject([ClothingServiceService], (service: ClothingServiceService) => {
    expect(service).toBeTruthy();
  }));
});
