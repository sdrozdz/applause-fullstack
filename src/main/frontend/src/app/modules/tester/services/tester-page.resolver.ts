import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Device, DeviceService} from "../../core/services/device.service";
import {forkJoin, Observable} from "rxjs";
import {CountryService} from "../../core/services/country.service";
import {map} from "rxjs/operators";
import {Injectable} from "@angular/core";

export interface TesterPageData {
  countries: string[];
  devices: Device[];
}

@Injectable()
export class TesterPageResolver implements Resolve<TesterPageData> {
  constructor(private countryService: CountryService, private deviceService: DeviceService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<TesterPageData> | Promise<TesterPageData> | TesterPageData {
    return forkJoin([
      this.countryService.getCountries(),
      this.deviceService.getDevices()
    ]).pipe(
      map(([countries, devices]) => ({countries, devices}))
    );
  }
}
