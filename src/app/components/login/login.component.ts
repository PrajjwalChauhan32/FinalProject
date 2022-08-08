import { Component, OnInit } from '@angular/core';
import { Merchant } from 'src/app/common/merchant';
import { CustomServiceService } from 'src/app/services/custom-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  merchants : Merchant[]

  constructor(private merchantService:CustomServiceService,private route:Router,private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.listOfMerchant();
  }

  loginSubmit(loginForm:any){
    // this.route.navigateByUrl("/transaction");
    for (let merchant of this.merchants) {
      if(loginForm.username === merchant.userName && loginForm.password === merchant.password){
        //this.merchantService.setUserLoggedIn();
        // localStorage.setItem('username', 'loginForm.username');
        this.merchantService.setUserLoggedIn();
        localStorage.setItem('loggedIn','true')
        this.route.navigateByUrl("/home");
      }
    // else{
    //   alert('invalid credentails...');
  
    // }

  }
}
listOfMerchant(){
  this.merchantService.getAllMerchant().subscribe(data=>{
    console.log(data)
  this.merchants=data
  })
}
}


