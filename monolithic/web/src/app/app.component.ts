import { Component, OnInit } from '@angular/core';
import {Special} from "./special";
import {AppService} from "./app.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Welcome to Bellisimo';
  loggedInUser = true;
  specials : Special[];

  constructor(private service : AppService) {
  }

  ngOnInit() : void {
    this.getAllSpecials();
  }

  getAllSpecials() :void{
    this.service.getAllSpecials().then(result =>
    {
      this.specials = result;
      console.log("specials: ", this.specials);
    });

  }
}
