import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TesterCriteriaComponent} from './tester-criteria.component';
import {TesterModule} from "../../tester.module";
import {NoopAnimationsModule} from "@angular/platform-browser/animations";
import {HarnessLoader} from "@angular/cdk/testing";
import {TestbedHarnessEnvironment} from "@angular/cdk/testing/testbed";
import {MatSelectHarness} from "@angular/material/select/testing";

let loader: HarnessLoader;

describe('TesterCriteriaComponent', () => {
  let component: TesterCriteriaComponent;
  let fixture: ComponentFixture<TesterCriteriaComponent>;

  const countries = ['PL', 'EN'];
  const devices = [{id: 1, description: 'test'}];
  const callbacks = {
    onCriteriaChange: (data: any) => {
      console.log('onCriteriaChange received', data)
    }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TesterCriteriaComponent],
      imports: [TesterModule, NoopAnimationsModule]
    })
      .compileComponents();
  });

  it('should create', async () => {
    // given
    createComponent();
    await loader.getAllHarnesses(MatSelectHarness);

    // then
    expect(component).toBeTruthy();
  });

  it('should allow to select all countries', async () => {
    // given
    const changeSpy = spyOn(callbacks, 'onCriteriaChange').and.callThrough();
    createComponent();
    const countriesSelect = await loader.getHarness(MatSelectHarness.with({selector: '#sd-countries-select'}));

    // when
    await countriesSelect.open();
    await countriesSelect.clickOptions({text: 'PL'});
    await countriesSelect.close();
    fixture.detectChanges();

    // then
    expect(component.form.get('country')?.value).toEqual(['PL']);
    expect(changeSpy).toHaveBeenCalledWith({device: [], country: ['PL']});
  });

  function createComponent() {
    fixture = TestBed.createComponent(TesterCriteriaComponent);
    component = fixture.componentInstance;
    loader = TestbedHarnessEnvironment.loader(fixture);
    component.devices = devices;
    component.countries = countries;
    component.onCriteriaChange.subscribe(callbacks.onCriteriaChange);

    fixture.detectChanges();
  }

});
