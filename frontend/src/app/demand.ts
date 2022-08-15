export class Demand {
  
    demandId:number=0;
    appName:string='';
    creation:Date= new Date();
    cloture:Date= new Date();
    etat:string='';
    clientName:string='';
    iscloture:boolean=false;
    constructor( appName:string='',
     creation:Date= new Date(),

    etat:string='',
   clientName:string='',cloture:boolean=false)
    {
        this.appName=appName;
        this.creation=creation;

        this.etat=etat;
        this.clientName=clientName;
        this.iscloture = cloture;
    }
    

}
