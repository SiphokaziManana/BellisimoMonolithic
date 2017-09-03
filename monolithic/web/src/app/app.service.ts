import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {Food} from "./food/food";
import {Clothing} from "./clothing/clothing";
import {Special} from "./special";
import {CustomResponse} from "./custom-response";

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

  createFoodItem(food: Food) : Promise<Food>{
    const url =`${this.BASE_URL}/item/add/`;

    var body = JSON.stringify(food);
    return this.http
      .post(url, body, {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Food)
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

  createSpecial(special: Special): Promise<CustomResponse>{
    const body = JSON.stringify({
      id : null,
      name : special.name,
      percentage : special.percentage,
      description: "The special description",
      startDate : null,
      endDate : null,
      image : null
    });
    //description : special.description,
    //.post(url, JSON.stringify({name: name}), {headers: this.headers})
    return this.http.post(this.BASE_URL+"/special/add", body, {headers: this.headers})
      .toPromise()
      .then(result => result.json() as CustomResponse);
  }

  addClothingItemToSpecial(): void{

  }


  getAllSpecials() : Promise<Special[]>{
    return this.http.get(this.BASE_URL + "/special/list").toPromise()
      .then(response => response.json() as Special[])
      .catch(this.handleError);
  }

  //@TODO: make this method return something meaningful
  addFoodItemToSpecial(item : Food, special : Special ) : Promise<CustomResponse>{
    const body = JSON.stringify({
      id : item.id,
      name : item.name,
      code : item.code,
      price : item.price,
      category : item.category,
      image : item.image,
      special : special.id,
      hasSpecial: true
    });
    return this.http.post(this.BASE_URL + "/item/add/special", body, {  headers: this.headers})
      .toPromise()
      .then(result => result.json() as CustomResponse);
  }
}
