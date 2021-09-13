import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class CountryService {
  readonly API_URL = '/api/country';

  constructor(private http: HttpClient) {
  }

  getCountries(): Observable<string[]> {
    return this.http.get<string[]>(this.API_URL);
  }
}
