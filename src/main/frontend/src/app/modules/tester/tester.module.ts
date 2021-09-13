import {NgModule} from '@angular/core';
import {TesterPageComponent} from './components/tester-page/tester-page.component';
import {MatSelectModule} from "@angular/material/select";
import {MatListModule} from "@angular/material/list";
import {TesterRoutingModule} from "./tester-routing.module";
import {CommonModule} from "@angular/common";
import {CoreModule} from "../core/core.module";
import {ReactiveFormsModule} from "@angular/forms";
import {TesterService} from "./services/tester.service";
import {MatTableModule} from "@angular/material/table";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [
    TesterPageComponent
  ],
  imports: [
    CommonModule,
    CoreModule,
    TesterRoutingModule,
    MatSelectModule,
    MatListModule,
    ReactiveFormsModule,
    MatTableModule,
    MatCheckboxModule,
    MatButtonModule
  ],
  providers: [
    TesterService
  ]
})
export class TesterModule {
}
