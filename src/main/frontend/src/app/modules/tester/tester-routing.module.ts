import {NgModule} from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import {TesterPageComponent} from "./components/tester-page/tester-page.component";
import {TesterPageResolver} from "./services/tester-page.resolver";

const routes: Route[] = [
  {
    path: '',
    component: TesterPageComponent,
    resolve: {
      pageData: TesterPageResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [TesterPageResolver]
})
export class TesterRoutingModule {

}
