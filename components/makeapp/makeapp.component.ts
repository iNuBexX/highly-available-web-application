import { Component, OnInit } from '@angular/core';
import { AppServiceService } from '../Services/app-service.service';
import { App } from '../app';
import { Router } from '@angular/router';
@Component({
  selector: 'app-makeapp',
  templateUrl: './makeapp.component.html',
  styleUrls: ['./makeapp.component.css'],
})
export class MakeappComponent implements OnInit {
  appName: string = '';
  os: string = '';
  version: string = '';
  desc: string = '';
  constructor(private appserivce: AppServiceService, private router: Router) {}
  ngOnInit(): void {}
  public submitnewapp() {
   // console.log("hi");
    let app = new App(this.appName, this.os, this.version, this.desc);
    this.appserivce.createNewapp(app);
   //console.log(app.os);
    let link: string[] = [];
    link.push('/applications');
    this.router.navigate(link);
  }
}
