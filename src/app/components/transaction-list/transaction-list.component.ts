import { ConditionalExpr } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Transaction } from 'src/app/common/transaction';
import { CustomServiceService } from 'src/app/services/custom-service.service';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {
  searchByPincode:number;
  searchByCustomerName:string;
  searchByUpperLimit:number;
  searchByLowerLimit:number;
  transactions :Transaction[];
  

  

  

  constructor(private service:CustomServiceService) { }
  

  ngOnInit(): void {
    this.listOfTransaction();
  }
  listOfTransaction(){
  this.service.getAllTransaction().subscribe(data=>{
    console.log(data)
  this.transactions=data
  })
}
getTransactionByPincode(){
  console.log(this.searchByPincode)
  this.service.getTransactionByPincode(this.searchByPincode).subscribe(data => {
  this.transactions = data
  // return this.transactions
  // console.log(this.filtertransactions)
  })
}

getTransactionByCustomerName(){
  console.log(this.searchByCustomerName)
  this.service.getTransactionByCustomerName(this.searchByCustomerName).subscribe(data => {
  this.transactions = data
  })
}
getTransactionByUpperLimit(){
  console.log(this.searchByUpperLimit)
  this.service.getTransactionByUpperLimit(this.searchByUpperLimit).subscribe(data => {
  this.transactions = data
  })
}
getTransactionByLowerLimit(){
  console.log(this.searchByLowerLimit)
  this.service.getTransactionByLowerLimit(this.searchByLowerLimit).subscribe(data => {
  this.transactions = data
  })
}

}

