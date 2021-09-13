import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CountryService} from "./services/country.service";
import {DeviceService} from "./services/device.service";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [CountryService, DeviceService]
})
export class CoreModule {
}
