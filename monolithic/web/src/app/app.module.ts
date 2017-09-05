import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { FoodComponent } from './food/food.component';
import { ClothingComponent, SearchFilterPipe } from './clothing/clothing.component';
import { ClothingDetailComponent } from './clothing-detail/clothing-detail.component';
import { FoodDetailComponent } from './food-detail/food-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppRoutingModule } from './app-routing.module';
import { AppService } from "./app.service";

import { AlertModule } from 'ngx-bootstrap';
import { ModalModule } from 'ngx-bootstrap';
import 'bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    FoodComponent,
    ClothingComponent,
    ClothingDetailComponent,
    FoodDetailComponent,
    DashboardComponent,
    SearchFilterPipe

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    AlertModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
