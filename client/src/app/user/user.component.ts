import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user/user.service';
import { PostService } from '../services/post/post.service';
import { PostExample } from '../services/post';
 
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  board: string;
  errorMessage: string;
 
  post = new PostExample();

  constructor(private postService: PostService, private userService: UserService) { }
 
  ngOnInit() {
    
  } 

  addPost(){
    console.log(this.post);
    this.postService.addPost(this.post).subscribe(res => {
      this.post.title = "";
      this.post.content = "";
    })
  }
}