import { Component, OnInit, Input } from '@angular/core';
import {Food} from "../food/food";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Location} from '@angular/common';
import 'rxjs/add/operator/switchMap';
import {AppService} from '../app.service';

@Component({
  selector: 'app-food-detail',
  templateUrl: './food-detail.component.html',
  styleUrls: ['./food-detail.component.css']
})
export class FoodDetailComponent implements OnInit {

  @Input()
  foodItem : Food;

  constructor(private service: AppService, private activatedRoute : ActivatedRoute,
              private location : Location ) { }

  ngOnInit() {
    this.activatedRoute.paramMap
      .switchMap((params: ParamMap) => this.service.getFoodItem(+params.get('id')))
      .subscribe(result => this.foodItem = result);
    console.log("we are in the food detail ngonit");
    console.log("there is a food item, it is: ", this.foodItem);
  }

  goBack(): void{
    this.location.back();
  }

  save() : void{
    this.service.updateFoodItem(this.foodItem)
      .then(() => this.goBack());
  }


}
