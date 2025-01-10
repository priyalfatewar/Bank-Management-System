// src/app/manager.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Manager } from './manager.model';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  private apiUrl = 'http://localhost:8085/api/managers';  // Replace with your actual API URL

  constructor(private http: HttpClient) { }

  // Create Manager
  createManager(manager: Manager): Observable<Manager> {
    return this.http.post<Manager>(this.apiUrl, manager);
  }

  // Get all Managers
  getManagers(): Observable<Manager[]> {
    return this.http.get<Manager[]>(this.apiUrl);
  }

  // Get Manager by ID
  getManagerById(id: number): Observable<Manager> {
    return this.http.get<Manager>(`${this.apiUrl}/${id}`);
  }

  // Update Manager
  updateManager(manager: Manager): Observable<Manager> {
    return this.http.put<Manager>(`${this.apiUrl}/${manager.id}`, manager);
  }

  // Delete Manager
  deleteManager(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
