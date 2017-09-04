import {Component, Input, OnInit} from '@angular/core';
import { Router } from "@angular/router";
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
    });
  }

  getSpecials():void{
    this.service.getAllSpecials().then(result => {
      this.specials = result;
    } );
  }

  changeView(value : boolean): void{
    this.isAdmin = value;
    this.isLoggedIn = value;

  }


  onSelect(food: Food) : void{
    this.item = food;
  }

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
          console.log("after update: ", result);
          window.location.reload();
        }
    );
  }

  //***************************************************************************************
//********************************** ADD ITEMS *******************************************
//***************************************************************************************

  onSubmitAddMeatItemForm(form: NgForm): void{
    this.new_item.code = "FOO";
    this.new_item.category = "FOOD";
    this.new_item.image = null;
    this.new_item.special = null;
    this.new_item.hasSpecial= false;
    this.service.createFoodItem(this.new_item)
      .then(result => {
        this.foodItems.push(result);
        window.location.reload();
      });
  }

//***************************************************************************************
//********************************** UPDATE ITEMS *****************************************
//***************************************************************************************

  onSubmitFoodUpdateForm(form : NgForm): void{
    this.service.updateFoodItem(this.item)
      .then( result => {
        console.log("after update: ", result);
        window.location.reload();
      })
  }

  removeSpecial(food : Food){
    food.special = null;
    food.hasSpecial = false;
    this.service.updateFoodItem(food)
      .then( result => {
        console.log("after update: ", result);
        window.location.reload();
      });
  }


}
