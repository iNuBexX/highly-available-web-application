import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Demand } from '../demand';
import { DemandesService } from '../Services/demandes.service';

@Component({
  selector: 'app-alldemands',
  templateUrl: './alldemands.component.html',
  styleUrls: ['./alldemands.component.css']
})
export class AlldemandsComponent implements OnInit {

  demands:Demand[]=[];
  constructor(private router: Router,private demandService:DemandesService  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('isLoggedin') == 'false' || localStorage.getItem('isLoggedin') ==null) {
      let link: string[] = [];
      link.push('/applications');
      localStorage.setItem('isLoggedin', 'true');
      this.router.navigate(link);

    }
    
    else 
    if (localStorage.getItem('username') != null)
    {let a:string;
    a=localStorage.getItem('username')+'';
    this.demandService.getalldemands().subscribe(data =>this.demands=data);

    
    }

    
  }
  onSelected(demand:Demand,state:string)
    {
      //this.demands.forEach(element=>console.log("ids are :" +element.demandId));
    //console.log(this.demands.length);
      //if(demand.etat != state)
       demand.etat = state ;
        this.demandService.updatedemande(demand,state);
    }

}
