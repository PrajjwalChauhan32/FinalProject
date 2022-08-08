import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Merchant } from 'src/app/common/merchant';
import { CustomServiceService } from 'src/app/services/custom-service.service';

@Component({
  selector: 'app-home-component',
  templateUrl: './home-component.component.html',
  styleUrls: ['./home-component.component.css']
})
export class HomeComponentComponent implements OnInit {
  

  constructor(private service:CustomServiceService,private route:Router) { }

  ngOnInit(): void {
  }
  logout(){
    this.service.setUserLoggedOut();
    this.route.navigateByUrl("/")
  }

}
