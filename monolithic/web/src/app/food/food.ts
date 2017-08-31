
import {Special} from "../special";

export class Food{
  id : number;
  name : string;
  code : string;
  price : number;
  category : string;
  image : string;
  special : Special;
  hasSpecial: boolean;

  constructor(){}
}

/*export const FOODS : Food[]  = [
  {
    id: 1,
    name: "Strawberry",
    price: 25.50
  },
  {
    id: 2,
    name: "Milk",
    price: 15.00
  },
  {
    id: 3 ,
    name: "Still Water",
    price: 8.00
  }
];*/
