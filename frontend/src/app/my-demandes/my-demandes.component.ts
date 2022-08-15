import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Demand} from 'src/app/demand';
import { DemandesService } from '../Services/demandes.service';
@Component({
  selector: 'app-my-demandes',
  templateUrl: './my-demandes.component.html',
  styleUrls: ['./my-demandes.component.css'],
})
export class MyDemandesComponent implements OnInit {
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
    this.demandService.getdemands(a).subscribe(data =>this.demands=data);
    }
  }
}
