
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {
  AccNumber:number=0;
  constructor(private router: Router) {}
  ngOnInit(): void {
    const accNo = sessionStorage.getItem('AccNo');
    this.AccNumber = accNo ? +accNo : 0;
  }
  // Navigate to different routes
  navigateTo(route: string) {
    this.router.navigate([route]);
  }

  onlogout(){
    sessionStorage.clear();
    this.router.navigate(['/customer-login']);
  }
}

