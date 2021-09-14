import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface SearchCriteriaDto {
  country: string[];
  device: number[];
}

export interface TesterDto {
  id: number;
  firstName: string;
  lastName: string;
  country: string;
  lastLogin: string;
  experience: number;
}

@Injectable()
export class TesterService {
  readonly API_URL = '/api/tester';

  constructor(private http: HttpClient) {
  }

  public getTesters(criteria: SearchCriteriaDto): Observable<TesterDto[]> {
    return this.http.post<TesterDto[]>(this.API_URL, criteria);
  }
}
