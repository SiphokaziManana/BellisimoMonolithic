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
  new_item = new Food();

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

  delete(food: Food) : void{
    this.service.delete(food.id)
      .then( () => {
        this.foodItems = this.foodItems.filter(h => h !== food);
        if (this.item === food){
          this.item = null;
        }
        window.location.reload();
        this.alertMessage = "Item successfully deleted";
        this.alert=true;

      });
  }

  falsifyAlert():void{
    this.alert = false;
  }

  displaySpecialForItem(): string{
    for ( let special of this.specials){
      if ( special.id == this.item.special){
        return special.name;
      }
    }
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

    for ( let special of this.specials){
      if ( special.id == this.special_id){
        this.specialForItem = special;
      }
    }
    this.service.addFoodItemToSpecial(this.item, this.specialForItem).then(
        result => {
          this.alertMessage = result.message;
          this.specialAlert = true;
          form.reset();
        }
    );
  }

  //***************************************************************************************
//********************************** ADD ITEMS *******************************************
//***************************************************************************************

  onSubmitAddMeatItemForm(form: NgForm): void{
    this.new_item.code = "MEA";
    this.new_item.category = "FOOD";
    this.new_item.image = null;
    this.new_item.special = null;
    this.new_item.hasSpecial= false;
    this.service.createFoodItem(this.new_item)
      .then(result => {
        this.meatItems.push(result);
        window.location.reload();
      });
  }

  onSubmitAddFruitItemForm(form: NgForm): void{
    this.new_item.code = "FRU";
    this.new_item.category = "FOOD";
    this.new_item.image = null;
    this.new_item.special = null;
    this.new_item.hasSpecial= false;
    this.service.createFoodItem(this.new_item)
      .then(result => {
        this.meatItems.push(result);
        window.location.reload();
      });

  }

  onSubmitAddDairyItemForm(form: NgForm): void{
    this.new_item.code = "DAI";
    this.new_item.category = "FOOD";
    this.new_item.image = null;
    this.new_item.special = null;
    this.new_item.hasSpecial= false;
    this.service.createFoodItem(this.new_item)
      .then(result => {
        this.meatItems.push(result);
        window.location.reload();
      });
  }

  //***************************************************************************************
//********************************** UPDATE ITEMS *****************************************
//***************************************************************************************

  onSubmitFoodUpdateForm(form : NgForm): void{
    this.service.updateFoodItem(this.item)
      .then( result => {
        window.location.reload();
      })
  }

  removeSpecial(food : Food){
    food.special = null;
    food.hasSpecial = false;
    this.service.updateFoodItem(food)
      .then( result => {
        window.location.reload();
      });
  }


}
