import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FoodComponent } from './food/food.component';
import { ClothingComponent } from './clothing/clothing.component';
import { FoodDetailComponent } from './food-detail/food-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClothingDetailComponent } from './clothing-detail/clothing-detail.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'food', component: FoodComponent },
  { path: 'clothing', component: ClothingComponent },
  { path: 'food/:id', component: FoodDetailComponent },
  { path: 'clothing/:id', component: ClothingDetailComponent }

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
