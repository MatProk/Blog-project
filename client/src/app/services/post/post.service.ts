import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Observable } from 'rxjs';
import { PostExample } from '../post';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
 
  constructor(private http: HttpClient, private tokenService: TokenStorageService) { }

  private posts = 'http://localhost:8081/posts';

  getPost(): Observable<PostExample> {
    return this.http.get<PostExample>(this.posts);
  }

  addPost(post: PostExample): Observable<PostExample>{
    return this.http.post<PostExample>(this.posts, post, this.httpOptions);
  }
}
