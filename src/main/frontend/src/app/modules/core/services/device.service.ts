import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface Device {
  id: number;
  description: string;
}

@Injectable()
export class DeviceService {
  readonly API_URL = '/api/device';

  constructor(private http: HttpClient) {
  }

  getDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(this.API_URL);
  }
}
