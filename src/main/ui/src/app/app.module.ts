import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

import { SimplegridComponent } from './simplegrid/simplegrid.component';
import { AppComponent }  from './app.component';
import { MockDataService } from './mockdata.service';
import { SimplegridService } from './simplegrid.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({ 
  imports: [ 
    CommonModule, 
    RouterOutlet, 
    BrowserModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(MockDataService, {dataEncapsulation:false}),
    SimplegridComponent
],
  declarations: [ AppComponent ],
  bootstrap:    [ AppComponent ],
  providers: [SimplegridService]
})
export class AppModule { }