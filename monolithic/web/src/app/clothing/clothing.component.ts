import { Component, OnInit, Pipe, PipeTransform, Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';


import { Clothing } from "./clothing";
import { AppService } from '../app.service';
import {Special} from "../special";

@Pipe({
  name: 'searchfilter'
})

@Injectable()
export class SearchFilterPipe implements PipeTransform{
  public transform(items: Clothing[], field : string, value:string) : Clothing[]{
    if (!items) return [];
    return items.filter(it => it[field] == value);
  }
}


@Component({
  selector: 'app-clothing',
  templateUrl: './clothing.component.html',
  styleUrls: ['./clothing.component.css']
})
export class ClothingComponent implements OnInit {

  clothingItems : Clothing[];
  item : Clothing;
  isAdmin = true;
  isLoggedIn = true;
  new_item = new Clothing();
  specialForItem : Special;
  new_special = new Special();
  specials : Special[] = [];
  alertMessage : string;
  alert : boolean = false;
  specialAlert : boolean = false;
  special_id : number;

  constructor(private service : AppService) { }

  ngOnInit() {
    this.getClothingItems();
    this.getSpecials();
  }

  changeView(value : boolean): void{
    this.isAdmin = value;
    this.isLoggedIn = value;

  }

  getClothingItems():void{
    this.service.getAllClothingItems().then(result => {
      this.clothingItems = result;
    });
  }

  getSpecials():void{
    this.service.getAllSpecials().then(result => {
      this.specials = result;
    });
  }

  onSelect(clothItem: Clothing) : void{
    this.item = clothItem;
  }

  delete(clothing: Clothing) : void{
    this.service.delete(clothing.id)
      .then( () => {
        this.clothingItems = this.clothingItems.filter(h => h !== clothing);
        if (this.item === clothing){
          this.item = null;
        }
        window.location.reload();
      });
  }

//***************************************************************************************
//********************************** ADD ITEMS ******************************************
//***************************************************************************************

  onSubmitAddClothingItemForm(form: NgForm): void{
    this.new_item.code = "CLO";
    this.new_item.category = "CLOTHING";
    this.new_item.image = null;
    this.new_item.special = null;
    this.new_item.hasSpecial= false;
    this.service.createClothingItem(this.new_item)
      .then(result => {
        this.clothingItems.push(result);
        window.location.reload();
      });
  }

//***************************************************************************************
//********************************** UPDATE ITEMS ***************************************
//***************************************************************************************
  onSubmitClothingUpdateForm(form : NgForm) : void {
    this.service.updateClothingItem(this.item)
      .then( result => {
        console.log("after update: ", result);
        window.location.reload();
      })
  }

//***************************************************************************************
//********************************** SPECIALS *******************************************
//***************************************************************************************

  displaySpecialForItem(): string{
    for ( let special of this.specials){
      if ( special.id == this.item.special){
        return special.name;
      }
    }
  }

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

  removeSpecial(clothing: Clothing):void{
    clothing.special = null;
    clothing.hasSpecial = false;
    this.service.updateClothingItem(clothing)
      .then( result => {
        console.log("after update: ", result);
        window.location.reload();
      });
  }
}
