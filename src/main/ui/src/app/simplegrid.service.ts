import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of, tap } from 'rxjs';
import { MockDataService } from './mockdata.service';

import { GridItem } from './griditem'

@Injectable({
  providedIn: 'root'
})
export class SimplegridService {
  rawdata : Object[] = [];
  data : GridItem[] = [];

  constructor(private http: HttpClient, sgService: MockDataService) { 
    this.rawdata = sgService.createDb().data;
  }

  getList(): Observable<GridItem[]> {
      return this.http.get<GridItem[]>('api/things').pipe(
          tap((response) => this.log(response)),
          catchError((error) => this.handleError(error, []))
      );
  }

  genId(data: GridItem[]): number {
    return data.length > 0 ? Math.max(...data.map(h => h.id)) + 1 : 11;
  }

  getListMock(): GridItem[] {
    let obj = Object.assign(this.rawdata.map(
      x => Object.values(x)).map(
        y => <GridItem>{ id : y[0], name : y[1]}
      )
    );
    return obj;
  }

  private log(response: GridItem[] | GridItem| undefined) {
    console.table(response);
  }

  private handleError(error: Error, errorValue: any) {
      console.error(error);
      return of(errorValue);
  }
}