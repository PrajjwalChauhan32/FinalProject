import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/common/cart';
import { CustomServiceService } from 'src/app/services/custom-service.service';

@Component({
  selector: 'app-product-report',
  templateUrl: './product-report.component.html',
  styleUrls: ['./product-report.component.css']
})
export class ProductReportComponent implements OnInit {
  carts:Cart[]

  constructor(private service:CustomServiceService) { }

  ngOnInit(): void {
    this.listOfProductByVolume();
  }
  listOfProductByVolume(){
    this.service.getProductVolumeReport().subscribe(data=>{
      console.log(data)
    this.carts=data
    })
  }

}
