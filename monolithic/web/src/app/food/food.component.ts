import {Component, Input, OnInit} from '@angular/core';
import { Router } from "@angular/router";
import { ModalModule } from 'ngx-bootstrap';
import { NgForm } from '@angular/forms';

import { Food } from './food';
import { AppService } from '../app.service';
import {Special} from "../special";


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
  specialForItem : Special;
  new_special = new Special();
  specials : Special[] = [];
  isAdmin = true;
  isLoggedIn = true;
  alertMessage : string;
  alert : boolean = false;
  specialAlert : boolean = false;
  special_id : number;

  constructor(private service : AppService, private router: Router) {
  }

  ngOnInit() : void {
    this.getFoodItems();
    this.getSpecials();
  }

  getFoodItems() : void{
    this.service.getAllFoodItems().then( result => {
      this.foodItems = result;
      this.sortFoodItems();
    });
  }

  getSpecials():void{
    this.service.getAllSpecials().then(result => {
      this.specials = result;
      console.log("All the specials", this.specials);
    } );
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
//***************************************************************************************
//********************************** SPECIALS *******************************************
//***************************************************************************************
  chosenSpecial(special: Special) : void{
    this.specialForItem = special;
  }

  onSubmitFoodSpecialForm(form : NgForm): void {
    console.log("submitting the special form", this.new_special);
    this.service.createSpecial(this.new_special).then(result => {
      console.log("the result is: ", result);
      form.reset();
      this.alertMessage = result.message;
      this.alert = true;
    });
  }

  onSubmitSpecialToItemForm(form : NgForm) : void{

    console.log("loking at form: ");
    console.log("form: ", form.value);
    console.log("special_id = ", this.special_id);
    for ( let special of this.specials){
      if ( special.id === this.special_id){
        this.specialForItem = special;
      }
    }

    /*this.service.addFoodItemToSpecial(this.item, this.specialForItem).then(
        result => {
          this.alertMessage = result.message;
          this.specialAlert = true;
          form.reset();
        }
    );*/

  }



  falsifyAlert():void{
    this.alert = false;
  }
}
