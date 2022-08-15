import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Demand } from '../demand';
@Injectable({
  providedIn: 'root'
})
export class DemandesService {

  constructor(private http:HttpClient) { }
  public getdemands(username:string)
  {
    const headers =  new HttpHeaders({Authorization: 'Basic ' + btoa(localStorage.getItem("username")+':'+localStorage.getItem("password")) });
    return this.http.post<Demand[]>("http://localhost:8080/api/demandes/specific",{"clientName":username},{headers})
  }  
  public senddemand(appname:string)
  {
    const headers =  new HttpHeaders({Authorization: 'Basic ' + btoa(localStorage.getItem("username")+':'+localStorage.getItem("password")) });
    return this.http.post<string>("http://localhost:8080/api/demandes",{"clientName":localStorage.getItem("username"),"appName":appname},{headers}).subscribe(data=>console.log(data));
  

  }
  public updatedemande(demand:Demand,state:string)
  {
    if (state =="CLOTURE")
    demand.iscloture = true;
    demand.etat=state;
    const headers =  new HttpHeaders({Authorization: 'Basic ' + btoa(localStorage.getItem("username")+':'+localStorage.getItem("password")) });
    console.log(demand.etat);
    this.http.patch("http://localhost:8080/api/demandes",{"demandId":demand.demandId,"isCloture":demand.iscloture,"etat":state},{headers}).subscribe(data =>console.log(data));
  }
  public getalldemands()
  {
    const headers =  new HttpHeaders({Authorization: 'Basic ' + btoa(localStorage.getItem("username")+':'+localStorage.getItem("password")) });
    return this.http.get<Demand[]>("http://localhost:8080/api/demandes",{headers});
  }
}
