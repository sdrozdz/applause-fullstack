import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Device} from "../../../core/services/device.service";
import {map} from "rxjs/operators";
import {SearchCriteriaDto, TesterDto, TesterService} from "../../services/tester.service";

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

  constructor(private activatedRoute: ActivatedRoute, private testerService: TesterService) {
  }

  ngOnInit(): void {
    this.activatedRoute.data
      .pipe(map(({pageData}) => pageData))
      .subscribe(({countries, devices}) => {
        this.countries = countries;
        this.devices = devices;
      });
  }

  search({country, device}: SearchCriteriaDto) {
    const criteria: SearchCriteriaDto = {
      country: country.filter((it: string) => !!it),
      device: device.filter((it: number) => !!it)
    };

    this.testerService.getTesters(criteria).subscribe(it => this.testers = it);
  }

}
