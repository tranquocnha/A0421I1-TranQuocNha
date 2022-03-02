import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionaryDetaiComponent } from './dictionary-detai.component';

describe('DictionaryDetaiComponent', () => {
  let component: DictionaryDetaiComponent;
  let fixture: ComponentFixture<DictionaryDetaiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DictionaryDetaiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionaryDetaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
