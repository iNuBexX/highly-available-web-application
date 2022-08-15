import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AlldemandsComponent } from './alldemands/alldemands.component';
import { ApplicationsComponent } from './applications/applications.component';
import { LoginComponent } from './login/login.component';
import { MakeappComponent } from './makeapp/makeapp.component';
import { MyDemandesComponent } from './my-demandes/my-demandes.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [

    {path: '', component: ApplicationsComponent  },
    {path: 'applications', component: ApplicationsComponent  },
    {path: 'demands', component: MyDemandesComponent  },
    {path: 'aboutus', component: AboutUsComponent },
    {path: 'login', component: LoginComponent },
    {path: 'signup', component: RegisterComponent},
    {path: 'alldemands', component: AlldemandsComponent},
    {path: 'makeapp', component: MakeappComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }