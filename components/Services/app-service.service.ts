import { Injectable } from '@angular/core';
import {HttpClient}  from '@angular/common/http';
import {App} from 'src/app/app';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppServiceService {


  myapps : App[]=[];
  constructor(private http: HttpClient) {}

  public getApplications(searchUrl: string) {
  return this.http.get<App[]>(searchUrl);

  
}
    public createNewapp(appRequest:App)
    {
     // console.log(appRequest.os);
      const headers =  new HttpHeaders({Authorization: 'Basic ' + btoa(localStorage.getItem("username")+':'+localStorage.getItem("password")) });
       this.http.post("http://localhost:8080/api/applications",appRequest,{headers}).subscribe(data =>console.log(data));
    }
    public delete(appname:string)
    {
      console.log("deleted");
      const headers =  new HttpHeaders({Authorization: 'Basic ' + btoa(localStorage.getItem("username")+':'+localStorage.getItem("password")) });
      this.http.post("http://localhost:8080/api/applications/delete",{"appName":appname},{headers}).subscribe(data =>console.log(data));
    }
}
interface Response {
  articles:{}
}
