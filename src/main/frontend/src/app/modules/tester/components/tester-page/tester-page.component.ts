import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Device} from "../../../core/services/device.service";
import {debounceTime, distinctUntilChanged, map} from "rxjs/operators";
import {FormBuilder, FormGroup} from "@angular/forms";
import {SearchCriteriaDto, TesterDto, TesterService} from "../../services/tester.service";
import {MatSelect} from "@angular/material/select";

@Component({
  selector: 'sd-tester-page',
  templateUrl: './tester-page.component.html',
  styleUrls: ['./tester-page.component.scss']
})
export class TesterPageComponent implements OnInit {

  displayedColumns = ['id', 'firstName', 'lastName', 'experience', 'country', 'lastLogin'];

  countries: string[] = [];
  devices: Device[] = [];
  testers: TesterDto[] = [];

  filterForm: FormGroup;

  @ViewChild('countriesSelect') countriesSelect!: MatSelect;
  @ViewChild('devicesSelect') devicesSelect!: MatSelect;

  identifiable = (index: number, item: { id: number }) => item.id;

  constructor(private activatedRoute: ActivatedRoute, private formBuilder: FormBuilder, private testerService: TesterService) {
    this.filterForm = this.createForm();
  }

  ngOnInit(): void {
    this.activatedRoute.data
      .pipe(map(({pageData}) => pageData))
      .subscribe(({countries, devices}) => {
        this.countries = countries;
        this.devices = devices;
      });

    this.filterForm.valueChanges.pipe(
      distinctUntilChanged(),
      debounceTime(50)
    ).subscribe(this.search.bind(this))
  }

  search() {
    const {country, device} = this.filterForm.value;

    const criteria: SearchCriteriaDto = {
      country: country.filter((it: string) => !!it),
      device: device.filter((it: number) => !!it)
    };

    this.testerService.getTesters(criteria).subscribe(it => this.testers = it);
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
