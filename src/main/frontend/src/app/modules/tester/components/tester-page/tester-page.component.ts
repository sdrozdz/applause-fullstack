import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Device} from "../../../core/services/device.service";
import {map} from "rxjs/operators";

@Component({
  selector: 'sd-tester-page',
  templateUrl: './tester-page.component.html',
  styleUrls: ['./tester-page.component.scss']
})
export class TesterPageComponent implements OnInit {

  countries: string[] = [];
  devices: Device[] = [];

  constructor(private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.data
      .pipe(map(({pageData}) => pageData))
      .subscribe(({countries, devices}) => {
        this.countries = countries;
        this.devices = devices;
      });
  }

}
