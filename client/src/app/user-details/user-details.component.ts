import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../services/user/user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  
  user;
  constructor(private token: TokenStorageService, private userService: UserService) { }

  ngOnInit() {
    this.userService.getUser().subscribe(data => this.user = data)
  }

}
