import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class UserService {
 
  private user = 'http://localhost:8080/api/test/user';
  private pm = 'http://localhost:8080/api/test/pm';
  private admin = 'http://localhost:8080/api/test/admin';
 
  constructor(private http: HttpClient) { }
 
  getUserBoard(): Observable<string> {
    return this.http.get(this.user, { responseType: 'text' });
  }
 
  getPMBoard(): Observable<string> {
    return this.http.get(this.pm, { responseType: 'text' });
  }
 
  getAdminBoard(): Observable<string> {
    return this.http.get(this.admin, { responseType: 'text' });
  }
}