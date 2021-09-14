import {Pipe, PipeTransform} from "@angular/core";

@Pipe({name: 'commaValues'})
export class CommaValuesPipe implements PipeTransform {
  transform(value: any[]): string {
    if (!value) {
      return value;
    }

    return value.filter((it: any) => !!it).map((it: any) => typeof it === 'string' ? it : it.description).join(', ');
  }
}
