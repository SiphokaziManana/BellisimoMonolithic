import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {Food} from "./food/food";
import {Clothing} from "./clothing/clothing";

@Injectable()
export class AppService {

  BASE_URL : string = "http://localhost:8080/api";
  private headers = new Headers({'Content-Type': 'application/json'});
  constructor(private http: Http) { }

  getAllFoodItems() : Promise<Food[]>{
    //@TODO: change this code so that it searches for all items that are category food only
    return this.http.get(this.BASE_URL + "/item/list").toPromise()
      .then(response => response.json() as Food[])
      .catch(this.handleError);
  }

  private handleError( err : any) : Promise<any>{
    console.error("An error occured in the service: ", err);
    //for demo purposes
    return Promise.reject(err.message || err);
  }

  getFoodItem(id : number) : Promise<Food>{
    return this.http.get(this.BASE_URL+"/item/find/" + id).toPromise()
      .then(result => result.json() as Food)
      .catch(this.handleError);
  }

  updateFoodItem( food: Food) : Promise<Food>{
    const url = `${this.BASE_URL}/item/update/${food.id}`;
    return this.http.put(url, JSON.stringify(food), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Food)
      .catch(this.handleError);
  }

  createFoodItem(name: String) : Promise<Food>{
    const url =`${this.BASE_URL}/item/add/`;
    return this.http
      .post(url, JSON.stringify({name: name}), {headers: this.headers})
      .toPromise()
      .then(res => res.json().data as Food)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.BASE_URL}/item/remove/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  getAllClothingItems() : Promise<Clothing[]>{
    return this.http.get(this.BASE_URL + "/item/list").toPromise()
      .then(response => response.json() as Clothing[])
      .catch(this.handleError);
  }

  createSpecial(): void{

  }

  addClothingItemToSpecial(): void{

  }

  addFoodItemToSpecial():void{

  }



}
