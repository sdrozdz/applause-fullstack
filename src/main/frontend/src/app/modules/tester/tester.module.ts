import {NgModule} from '@angular/core';
import {TesterPageComponent} from './components/tester-page/tester-page.component';
import {MatSelectModule} from "@angular/material/select";
import {MatListModule} from "@angular/material/list";
import {TesterRoutingModule} from "./tester-routing.module";
import {CommonModule} from "@angular/common";
import {CoreModule} from "../core/core.module";


@NgModule({
  declarations: [
    TesterPageComponent
  ],
  imports: [
    CommonModule,
    CoreModule,
    TesterRoutingModule,
    MatSelectModule,
    MatListModule
  ]
})
export class TesterModule {
}
