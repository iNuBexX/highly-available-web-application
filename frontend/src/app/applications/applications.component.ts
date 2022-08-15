import { Component, OnInit } from '@angular/core';
import {App} from 'src/app/app';
import { AppServiceService } from 'src/app/Services/app-service.service';
import { AuthServiceService } from '../Services/auth-service.service';
import { DemandesService } from '../Services/demandes.service';

@Component({
  selector: 'app-applications',
  templateUrl: './applications.component.html',
  styleUrls: ['./applications.component.css']
})
export class ApplicationsComponent implements OnInit {

  apps:App[] = [];
  isLoggedIn:boolean;
  status:string='';
  constructor(private myappService: AppServiceService,private auth:AuthServiceService,private demandService:DemandesService) { 
    if (localStorage.getItem("isLoggedin")=="true")
    this.isLoggedIn=true;
    else
    this.isLoggedIn=false;
    if(localStorage.getItem("status")=="ADMIN")
    this.status='ADMIN';
  }

  ngOnInit(): void {
    
    this.myappService.getApplications("http://localhost:8080/api/applications").subscribe(data =>{this.apps=data;
    //console.log("the os is: "+this.apps[0].os);
  });
    
  }
  public senddemand(appname:string)
  {
    
    this.demandService.senddemand(appname);
  }
  public delete(appname:string)
  {
    this.myappService.delete(appname);
    }


}
