import { Component, OnInit } from '@angular/core';
 
import { TokenStorageService } from '../auth/token-storage.service';
import { PostService } from '../services/post/post.service';
import { HttpErrorResponse } from '@angular/common/http';
 
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;
  posts;
  postsArray: string [];
 
  constructor(private postService: PostService, private token: TokenStorageService) { }
 
  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
    };

    this.postService.getPost().subscribe(
      data => {
        this.postsArray = data as string [];	 // FILL THE ARRAY WITH DATA.
        console.log(this.postsArray);
      },
      (err: HttpErrorResponse) => {
        console.log (err.message);
      }
    );
    
  }

}