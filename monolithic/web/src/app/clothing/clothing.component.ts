import { Component, OnInit } from '@angular/core';
import { Clothing } from "./clothing";
import { AppService } from '../app.service';

@Component({
  selector: 'app-clothing',
  templateUrl: './clothing.component.html',
  styleUrls: ['./clothing.component.css']
})
export class ClothingComponent implements OnInit {

  clothingItems : Clothing[];
  item : Clothing;
  underwearItems : Clothing[] = [];
  clothItems : Clothing[] = [];
  shoeItems: Clothing[] = [];
  isAdmin = true;
  isLoggedIn = true;

  constructor(private service : AppService) { }

  ngOnInit() {
    this.getClothingItems();
  }

  getClothingItems():void{
    this.service.getAllClothingItems().then(result => {
      this.clothingItems = result;
      this.sortClothingItems();
    })
  }
  sortClothingItems():void{
    for ( let temp of this.clothingItems){
      switch (temp.code)
      {
        case "UND":
          this.underwearItems.push(temp);
          break;
        case "CLO":
          this.clothItems.push(temp);
          break;
        case "SHO":
          this.shoeItems.push(temp);
          break;
      }
    }
  }
  onSelect(clothItem: Clothing) : void{
    this.item = clothItem;
  }

  add(name: string): void {

  }

  delete(cloth: Clothing) : void{
    this.service.delete(cloth.id)
      .then( () => {
        this.clothingItems = this.clothingItems.filter(h => h !== cloth);
        if (this.item === cloth){
          this.item = null;
        }
      });
  }

}
