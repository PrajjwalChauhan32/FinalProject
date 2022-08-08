import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { Routes,RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
//import { AuthGuard } from './auth.guard';
import {MatTableModule} from '@angular/material/table';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { TransactionListComponent } from './components/transaction-list/transaction-list.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthGuard } from './auth.guard';
import { ReportComponent } from './components/report/report.component';
import { ProductReportComponent } from './components/product-report/product-report.component';

const routes:Routes=[
  {path:'',component:LoginComponent},
  {path:'transaction',component:TransactionListComponent},
  {path:'home',component:HomeComponentComponent},
  {path:'report',component:ReportComponent},
  {path:'product',component:ProductReportComponent},
  // {path:'categories',component:CategoryListComponent},
  // {path:'prodform',component:ProdFormComponent},
  // {path:'buyProd',component:BuyerComponent},
  // {path:"update/:prodid",component:ProdFormComponent},
  // {path:"products/:prodName",component:ProductListComponent},
  // {path:"search/:searchNAme",component:ProductListComponent},
  // {path:'login',component:LoginComponent},
  // {path:'logout',component:LogoutComponent}

]
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TransactionListComponent,
    HomeComponentComponent,
    ReportComponent,
    ProductReportComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    BrowserAnimationsModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
