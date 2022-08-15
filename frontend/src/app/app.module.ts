import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ApplicationsComponent } from './applications/applications.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { MyDemandesComponent } from './my-demandes/my-demandes.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { MakeappComponent } from './makeapp/makeapp.component';
import { AlldemandsComponent } from './alldemands/alldemands.component';

@NgModule({
  declarations: [
    AppComponent,
    ApplicationsComponent,
    AboutUsComponent,
    MyDemandesComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    MakeappComponent,
    AlldemandsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
