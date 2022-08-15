import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

    username:string="";
    password:string="";
  constructor(private router:Router,private http:HttpClient) { }
  login()
  {
    let link:string[]=[];
    link.push("/login");
    this.router.navigate(link);
  }
  register()
  {
    console.log(this.username,this.password);
    this.http.post<String>("http://localhost:8080/api/registration",{ "userName":this.username,
    "password":this.password}).subscribe(data=>console.log(data));
    let link:string[]=[];
    link.push("/login");
    this.router.navigate(link);
    
  }

  ngOnInit(): void {
  }

}
