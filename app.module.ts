import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountComponent } from './account/account.component';
import { TransactionComponent } from './transaction/transaction.component';
import { DepositComponent } from './transaction/deposit/deposit.component';
import { WithdrawComponent } from './transaction/withdraw/withdraw.component';
import { TransferMoneyComponent } from './transfer-money/transfer-money.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { GetBalanceComponent } from './get-balance/get-balance.component';
import { DeleteAccountComponent } from './delete/delete.component';  // Check the path
import { UpdateAccountComponent } from './update-details/update-details.component';  // Check the path
import { AccountDetailsComponent } from './get-details/get-details.component';  // Check the path
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { ManagerComponent } from './manager/manager.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CustomerComponent } from './customers/customers.component';
import { ViewComponent } from './view/view.component';
import { UpdateComponent } from './update/update.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeDeleteComponent } from './employee-delete/employee-delete.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ManagerLoginComponent } from './manager-login/manager-login.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    TransactionComponent,
    DepositComponent,
    WithdrawComponent,
    TransferMoneyComponent,
    TransactionHistoryComponent,
    GetBalanceComponent,
    DeleteAccountComponent,  // Ensure correct path
    AccountDetailsComponent,  // Ensure correct path
    UpdateAccountComponent,  // Ensure correct path
    DashboardComponent,
    HomepageComponent,
    LoginComponent,
    ManagerComponent,
    NavbarComponent,
    CustomerComponent,
    ViewComponent,
    UpdateComponent,
    CustomerLoginComponent,
    CustomerDashboardComponent,
    EmployeeCreateComponent,
    EmployeeDeleteComponent,
    EmployeeEditComponent,
    EmployeeListComponent,
    NavigationComponent,
    ManagerLoginComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
