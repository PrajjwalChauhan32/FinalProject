import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Transaction } from '../common/transaction';
import { map, Observable, Timestamp } from 'rxjs';
import { Merchant } from '../common/merchant';
import { Cart } from '../common/cart';

@Injectable({
  providedIn: 'root'
})
export class CustomServiceService {
  private transactionURL = "http://localhost:8080/api/transaction"
  private merchantURL = "http://localhost:8080/api/merchant"
  isUserLoggedIN = false;
  getLoggedStatus(){
    return this.isUserLoggedIN;
  }
  setUserLoggedIn(){
    this.isUserLoggedIN = true;

  }
  setUserLoggedOut(){
    this.isUserLoggedIN = false;
  }

  constructor(private httpClient:HttpClient) { }

  getAllTransaction():Observable<Transaction[]>{
    return this.httpClient.get<GetResponseTransaction>(this.transactionURL).pipe(map(response =>response._embedded.transactions));
   

  }
  getAllMerchant():Observable<Merchant[]>{
    return this.httpClient.get<GetResponseMerchant>(this.merchantURL).pipe(map(response =>response._embedded.merchants));
   

  }
  getTransactionByPincode(pincode:number){
    const transactionByPincodeURL="http://localhost:8080/api/transaction/search/findByPincode?pincode="+pincode

    return this.httpClient.get<GetResponseTransaction>(transactionByPincodeURL).pipe(map(response => response._embedded.transactions))

  }
  getTransactionByCustomerName(customerName:string){
    const transactionByCustomerNameURL="http://localhost:8080/api/transaction/search/findByCustomerName?customerName="+customerName

    return this.httpClient.get<GetResponseTransaction>(transactionByCustomerNameURL).pipe(map(response => response._embedded.transactions))

  }
  getTransactionByUpperLimit(upperLimit:number){
    const transactionByUpperLimitURL="http://localhost:8080/api/transaction/search/findByTotalAmountGreaterThan?totalAmount="+upperLimit

    return this.httpClient.get<GetResponseTransaction>(transactionByUpperLimitURL).pipe(map(response => response._embedded.transactions))

  }
  getTransactionByLowerLimit(lowerLimit:number){
    const getTransactionByLowerLimitURL="http://localhost:8080/api/transaction/search/findByTotalAmountLessThan?totalAmount="+lowerLimit

    return this.httpClient.get<GetResponseTransaction>(getTransactionByLowerLimitURL).pipe(map(response => response._embedded.transactions))

  }
  getTransactionBetweenDate(startDate:Date,endDate:Date){
    const getTransactionBetweenDateURL="http://localhost:8080/api/transaction/search/findByPurchasedAt?t1="+startDate+"&t2="+endDate

    return this.httpClient.get<GetResponseTransaction>(getTransactionBetweenDateURL).pipe(map(response => response._embedded.transactions))

  }
  getTransactionByCustomerVolume(start:Date,end:Date){
    const getTransactionBetweenDateURL="http://localhost:8080/api/transaction/search/getTransactionsReportByCustomerVolume?t1="+start+"&t2="+end

    return this.httpClient.get<GetResponseTransaction>(getTransactionBetweenDateURL).pipe(map(response => response._embedded.transactions))

  }
  getProductVolumeReport(){
    const getProductVolumeReportURL="http://localhost:8080/api/cart/search/getProductVolumeReport"

    return this.httpClient.get<GetResponseCart>(getProductVolumeReportURL).pipe(map(response => response._embedded.carts))

  }
  getCustomerValueReport(start:Date,end:Date){
    const getCustomerValueReportURL="http://localhost:8080/api/transaction/search/getCustomerValueReport?t1="+start+"&t2="+end

    return this.httpClient.get<GetResponseTransaction>(getCustomerValueReportURL).pipe(map(response => response._embedded.transactions))

  }
  // http://localhost:8080/api/transaction/search/getCustomerValueReport{?t1,t2}
 
}
interface GetResponseTransaction{
  _embedded:{
    transactions:Transaction[]
  }
 }
 interface GetResponseMerchant{
  _embedded:{
    merchants:Merchant[]
  }
 }
 interface GetResponseCart{
  _embedded:{
    carts:Cart[]
  }
 }
 