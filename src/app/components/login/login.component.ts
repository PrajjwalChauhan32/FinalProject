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

    var flag:boolean=true;
    for (var merchant of this.merchants) {
      if(loginForm.username === merchant.userName && loginForm.password === merchant.password ){
        this.merchantService.setUserLoggedIn();
        localStorage.setItem("merchantID",merchant.merchantId.toString())
        localStorage.setItem('loggedIn','true')
        // this.route.navigateByUrl("/home");
        flag=true;
        break;
      }else{
      flag=false;
      // alert('invalid credentails...');
      }
    }if(flag === true){
        this.route.navigateByUrl("/home")
      }
      else{
        alert("Invalid Credentials");
      }
  }
listOfMerchant(){
  this.merchantService.getAllMerchant().subscribe(data=>{
    console.log(data)
  this.merchants=data
  })
}
}


