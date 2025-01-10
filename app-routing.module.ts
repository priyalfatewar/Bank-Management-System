import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { TransactionComponent } from './transaction/transaction.component';
import { TransferMoneyComponent } from './transfer-money/transfer-money.component';
import { GetBalanceComponent } from './get-balance/get-balance.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UpdateAccountComponent } from './update-details/update-details.component';
import { DeleteAccountComponent } from './delete/delete.component';
import { AccountDetailsComponent } from './get-details/get-details.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ManagerLoginComponent } from './manager-login/manager-login.component';
import { LoginComponent } from './login/login.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeDeleteComponent } from './employee-delete/employee-delete.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { CustomerComponent } from './customers/customers.component';
import { UpdateComponent } from './update/update.component';
import { ViewComponent } from './view/view.component';

// Define the routes
const routes: Routes = [
  { path: 'accounts', component: AccountComponent }, // Route for AccountComponent
  { path: 'transactions', component: TransactionComponent }, // Route for TransactionComponent
  { path: '', redirectTo: '/homepage', pathMatch: 'full' }, 
  { path: 'dashboard/:accountId', component: DashboardComponent },  // Dashboard after account creation
  { path: 'update/:accountId', component: UpdateAccountComponent },  // Update account details
  { path: 'delete/:accountId', component: DeleteAccountComponent },// Redirect to AccountComponent by default
  { path: 'transfer-money', component: TransferMoneyComponent },
  { path: 'get-balance', component: GetBalanceComponent },
  { path: 'transaction-history', component: TransactionHistoryComponent },
  { path: 'homepage', component: HomepageComponent },
  { path: 'loginAdmin', component: LoginComponent},
  { path: 'loginmanager', component: ManagerLoginComponent },
  { path: 'customer-login', component: CustomerLoginComponent },
  { path: 'manager', component: ManagerComponent },
  { path: 'employee-create', component: EmployeeCreateComponent },
  { path: 'employee-edit', component: EmployeeEditComponent },
  { path: 'employee-list', component: EmployeeListComponent },
  { path: 'employee-delete', component: EmployeeDeleteComponent},
  { path: 'customer-dashboard', component: CustomerDashboardComponent},
  { path: 'customers', component: CustomerComponent},
  { path: 'update', component: UpdateComponent},
  { path: 'view', component: ViewComponent},

  
  

  

  {path:'get-details',component:AccountDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Use RouterModule with the defined routes
  exports: [RouterModule] // Export RouterModule to be used in other modules
})
export class AppRoutingModule { }
