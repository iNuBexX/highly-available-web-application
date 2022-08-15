import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../Services/auth-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public username: string="";
  public password: string="";
  constructor(private auth:AuthServiceService,private router:Router) { }

  ngOnInit(): void {
   

  }
  public sumbitCredentials()
  {
 this.auth.login(this.username,this.password);
 
  }
  public register()
  {
    let link:string[]=[];
 link.push("/signup");
 this.router.navigate(link);
  }

}
