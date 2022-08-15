export class App {
    appId:string='';
    appName:string='';
    os:string='';
    version: string='';
    description:string='';
    constructor( appName:string,
    os:string,
    version: string,
    desc:string)
    {
        this.appName=appName;
        this.os=os;
        this.version=version;
        this.description=desc;
    }
    public getOS()
    {
        return this.os;
    }
}
