import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../Services/auth-service.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn: boolean=false;
  status:string ='';

  constructor(private router: Router,private auth: AuthServiceService ) { 
    if (localStorage.getItem("isLoggedin")=="true")
    this.isLoggedIn=true;
    else
    this.isLoggedIn=false;
  //  this.auth.mystatus.subscribe(data => this.status = data);
  }

  ngOnInit(): void {
    this.auth.mystatus.subscribe(data => this.status = data);
  this.auth.isLoggedIn.subscribe(data=>this.isLoggedIn=data);
  console.log(this.status);
  console.log(this.isLoggedIn);
  }
  goto(page:string)
  {
    this.router.navigate([page]);

  }
  logout()
  {
    this.auth.logout();
  }
  createapp()
  {
    console.log("creating apps ...");
  }

}
