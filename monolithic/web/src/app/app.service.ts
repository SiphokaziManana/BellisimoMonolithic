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
  BASE_URL_MICROSERVICES : string = "http://137.215.42.229:8761/api";

  private headers = new Headers({'Content-Type': 'application/json'});
  constructor(private http: Http) { }

  private handleError( err : any) : Promise<any>{
    console.error("An error occured in the service: ", err);
    //for demo purposes
    return Promise.reject(err.message || err);
  }

  // =========================================================
  // ---------------- GET
  // =========================================================
  getAllFoodItems() : Promise<Food[]>{
    //@TODO: change this code so that it searches for all items that are category food only
    //return this.http.get(this.BASE_URL + "/item/list/food").toPromise()
    return this.http.get(this.BASE_URL_MICROSERVICES + "/item/list/food").toPromise()
      .then(response => response.json() as Food[])
      .catch(this.handleError);
  }

  getAllClothingItems() : Promise<Clothing[]>{
    //return this.http.get(this.BASE_URL + "/item/list/clothing").toPromise()
    return this.http.get(this.BASE_URL_MICROSERVICES + "/item/list/clothing").toPromise()
      .then(response => response.json() as Clothing[])
      .catch(this.handleError);
  }

  getAllSpecials() : Promise<Special[]>{
    //return this.http.get(this.BASE_URL + "/special/list").toPromise()
    return this.http.get(this.BASE_URL_MICROSERVICES + "/special/list").toPromise()
      .then(response => response.json() as Special[])
      .catch(this.handleError);
  }

  getFoodItem(id : number) : Promise<Food>{
    //return this.http.get(this.BASE_URL+"/item/find/" + id).toPromise()
    return this.http.get(this.BASE_URL_MICROSERVICES+"/item/find/" + id).toPromise()
      .then(result => result.json() as Food)
      .catch(this.handleError);
  }

  // =========================================================
  // ---------------- PUT
  // =========================================================
  updateFoodItem( food: Food) : Promise<Food>{
    //const url = `${this.BASE_URL}/item/update/${food.id}`;
    const url = `${this.BASE_URL_MICROSERVICES}/item/update/${food.id}`;
    return this.http.put(url, JSON.stringify(food), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Food)
      .catch(this.handleError);
  }
  updateClothingItem( clothing: Clothing) : Promise<Clothing>{
    //const url = `${this.BASE_URL}/item/update/${clothing.id}`;
    const url = `${this.BASE_URL_MICROSERVICES}/item/update/${clothing.id}`;
    return this.http.put(url, JSON.stringify(clothing), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Food)
      .catch(this.handleError);
  }

  // =========================================================
  // ---------------- POST
  // =========================================================
  createFoodItem(food: Food) : Promise<Food>{
    //const url =`${this.BASE_URL}/item/add/`;
    const url =`${this.BASE_URL_MICROSERVICES}/item/add/`;
    var body = JSON.stringify(food);
    return this.http
      .post(url, body, {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Food)
      .catch(this.handleError);
  }

  createClothingItem(clothing : Clothing): Promise<Clothing>{
    //const url =`${this.BASE_URL}/item/add/`;
    const url =`${this.BASE_URL_MICROSERVICES}/item/add/`;
    var body = JSON.stringify(clothing);
    return this.http
      .post(url, body, {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Food)
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
    //return this.http.post(this.BASE_URL+"/special/add", body, {headers: this.headers})
    return this.http.post(this.BASE_URL_MICROSERVICES+"/special/add", body, {headers: this.headers})
      .toPromise()
      .then(result => result.json() as CustomResponse);
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
    //return this.http.post(this.BASE_URL + "/item/add/special", body, {  headers: this.headers})
    return this.http.post(this.BASE_URL_MICROSERVICES + "/item/add/special", body, {  headers: this.headers})
      .toPromise()
      .then(result => result.json() as CustomResponse);
  }

  // =========================================================
  // ---------------- DELETE
  // =========================================================

  delete(id: number): Promise<void> {
    //const url = `${this.BASE_URL}/item/remove/${id}`;
    const url = `${this.BASE_URL_MICROSERVICES}/item/remove/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

}
