import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Subject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthServiceService {
  isLoggedIn: Subject<boolean> = new BehaviorSubject<boolean>(false);
  userid: Subject<number> = new BehaviorSubject<number>(0);
  username: Subject<string> = new BehaviorSubject<string>('');
  password: Subject<string> = new BehaviorSubject<string>('');
  mystatus: Subject<string> = new BehaviorSubject<string>('');
  authenticated = false;
  constructor(private http: HttpClient, private router: Router) {
    if (
      localStorage.getItem('isLoggedin') == 'true' &&
      localStorage.getItem('username') != null &&
      localStorage.getItem('password') != null
    )
      this.isLoggedIn.next(true);
      if(localStorage.getItem('status')=='ADMIN')
      this.mystatus.next('ADMIN');
  }
  public login(username: string, password: string) {
    const headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(username + ':' + password),
    });
    this.http
      .get<string>('http://localhost:8080/mylogin', {
        headers,
        responseType: 'text' as 'json',
      })
      .subscribe((data) => {
        if (data == 'loggedin') {
          this.isLoggedIn.next(true);
          localStorage.setItem('isLoggedin', 'true');
          localStorage.setItem('username', username);
          localStorage.setItem('password', password);

          this.getstatus().subscribe((data) => {
            this.mystatus.next(data);
            localStorage.setItem("status",data);
            //console.log(data);
          });
          //console.log("login status:"+localStorage.getItem("isLoggedin"));
          if (localStorage.getItem('isLoggedin') == 'true') {
            let link: string[] = [];
            link.push('/applications');
            localStorage.setItem('isLoggedin', 'true');
            this.router.navigate(link);
          }
        }
      });
  }
  public logout() {
    this.http.post('http://localhost:8080/logout/', {});
    this.userid.next(-1);
    this.username.next('');
    this.password.next('');
    localStorage.setItem('isLoggedin', 'false');
    this.isLoggedIn.next(false);
    this.mystatus.next('');

    let link: string[] = [];
    link.push('/login');
    this.router.navigate(link);
  }
  public getstatus() {


    const headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(localStorage.getItem('username')+ ':' + localStorage.getItem('password')),
    });

    return this.http.get<string>('http://localhost:8080/usernameandstatus', {
      headers,
      responseType: 'text' as 'json',
    });
  }
}
