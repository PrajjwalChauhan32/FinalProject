import { Component, OnInit } from '@angular/core';
import { Transaction } from 'src/app/common/transaction';
import { CustomServiceService } from 'src/app/services/custom-service.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  transactions:Transaction[]
  searchByStartDate:Date
  searchByEndDate:Date
  searchByStart:Date
  searchByEnd:Date

  constructor(private service:CustomServiceService) { }

  ngOnInit(): void {
    this.listOfTransaction()
  }
  listOfTransaction(){
    this.service.getAllTransaction().subscribe(data=>{
      console.log(data)
    this.transactions=data
    })
  }
  getTransactionBetweenDate(search:any){
    console.log(this.searchByStartDate,this.searchByEndDate)
    this.service.getTransactionBetweenDate(search.searchByStartDate,search.searchByEndDate).subscribe(data => {
    this.transactions = data
    })

  }
  getTransactionByCustomerVolume(search2:any){
    console.log(this.searchByStart,this.searchByEnd)
    this.service.getTransactionByCustomerVolume(search2.searchByStart,search2.searchByEnd).subscribe(data => {
    this.transactions = data
    })

  }

}
