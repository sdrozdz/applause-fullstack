import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TesterPageComponent} from './tester-page.component';
import {TesterModule} from "../../tester.module";
import {NoopAnimationsModule} from "@angular/platform-browser/animations";
import {CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {of} from "rxjs";

describe('TesterPageComponent', () => {
  let component: TesterPageComponent;
  let fixture: ComponentFixture<TesterPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TesterPageComponent],
      imports: [TesterModule, NoopAnimationsModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            data: of()
          }
        }
      ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TesterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
