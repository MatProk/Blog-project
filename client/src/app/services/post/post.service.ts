import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

// , 'Authorization': 'Bearer ' + this.tokenService.getToken() }

@Injectable({
  providedIn: 'root'
})
export class PostService {
 
  constructor(private http: HttpClient, private tokenService: TokenStorageService) { }

  private posts = 'http://localhost:8081/posts';

  getPost(): Observable<any> {
    return this.http.get(this.posts);
  }
}
