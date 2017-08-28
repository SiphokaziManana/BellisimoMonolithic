import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { ModalModule } from 'ngx-bootstrap';

import { Food } from './food';
import { AppService } from '../app.service';


@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent implements OnInit {

  foodItems : Food[];
  item : Food;
  meatItems : Food[] = [];
  fruitItems : Food[] = [];
  dairyItems: Food[] = [];
  isAdmin = true;
  isLoggedIn = true;



  constructor(private service : AppService, private router: Router) {
  }

  ngOnInit() : void {
    this.getFoodItems();
  }

  getFoodItems() : void{
    this.service.getAllFoodItems().then( result => {
      this.foodItems = result;
      this.sortFoodItems();
    });
  }

  sortFoodItems(): void{
    for ( let temp of this.foodItems){
      switch (temp.code)
      {
        case "MEA":
          this.meatItems.push(temp);
          break;
        case "FRU":
          this.fruitItems.push(temp);
          break;
        case "DAI":
          this.dairyItems.push(temp);
          break;
      }
    }
  }


  onSelect(food: Food) : void{
    this.item = food;
  }

  /*gotoDetail(foodItem: Food) : void{
    this.item = foodItem;
    this.router.navigate(['/food', this.item.id]);
  }*/

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.service.createFoodItem(name)
      .then(food => {
        this.foodItems.push(food);
        this.item = null;
      });
  }

  delete(food: Food) : void{
    this.service.delete(food.id)
      .then( () => {
        this.foodItems = this.foodItems.filter(h => h !== food);
        if (this.item === food){
          this.item = null;
        }
      });
  }

}
