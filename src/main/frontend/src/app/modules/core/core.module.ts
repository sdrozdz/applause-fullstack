import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CountryService} from "./services/country.service";
import {DeviceService} from "./services/device.service";
import {HttpClientModule} from "@angular/common/http";
import {FlexLayoutModule} from "@angular/flex-layout";
import {CommaValuesPipe} from "./pipes/comma-values.pipe";


@NgModule({
  declarations: [CommaValuesPipe],
  imports: [
    CommonModule,
    HttpClientModule,
    FlexLayoutModule
  ],
  exports: [
    FlexLayoutModule,
    CommaValuesPipe
  ],
  providers: [CountryService, DeviceService]
})
export class CoreModule {
}
