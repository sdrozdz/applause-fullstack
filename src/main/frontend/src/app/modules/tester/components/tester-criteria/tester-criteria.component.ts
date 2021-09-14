import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Device} from "../../../core/services/device.service";
import {SearchCriteriaDto} from "../../services/tester.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {MatSelect} from "@angular/material/select";
import {debounceTime, distinctUntilChanged, map} from "rxjs/operators";

@Component({
  selector: 'sd-tester-criteria',
  templateUrl: './tester-criteria.component.html',
  styleUrls: ['./tester-criteria.component.scss']
})
export class TesterCriteriaComponent implements OnInit {

  @Input()
  countries: string[] = [];

  @Input()
  devices: Device[] = [];

  @Output()
  onCriteriaChange = new EventEmitter<SearchCriteriaDto>();

  @ViewChild('countriesSelect') countriesSelect!: MatSelect;
  @ViewChild('devicesSelect') devicesSelect!: MatSelect;

  form: FormGroup;

  identifiable = (index: number, item: { id: number }) => item.id;

  compareIdentifiable = (o1: { id: number }, o2: { id: number }) => {
    return o1.id === o2.id;
  }

  constructor(private formBuilder: FormBuilder) {
    this.form = this.createForm();
  }

  ngOnInit(): void {
    this.form.valueChanges.pipe(
      distinctUntilChanged(),
      debounceTime(50),
      map(({device, country}) => ({
        device: device.filter((it: Device) => !!it).map((it: Device) => it.id),
        country
      }))
    ).subscribe(data => this.onCriteriaChange.emit(data));
  }

  toggleSelectAll(select: MatSelect) {
    if (select.options.first.selected) {
      select.options.map(it => it.select());
    } else {
      select.options.map(it => it.deselect());
    }
  }

  toggleOption(select: MatSelect): void {
    if (select.options.first.selected) {
      select.options.first.deselect();
    } else if (select.options.filter(it => it.selected).length === select.options.length - 1) {
      select.options.first.select();
    }
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
      country: [[]],
      device: [[]],
    });
  }
}
