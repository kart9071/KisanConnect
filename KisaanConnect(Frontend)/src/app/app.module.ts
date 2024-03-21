import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './my_components/home/home.component';
import { LoginComponent } from './my_components/login/login.component';
import { RegisterComponent } from './my_components/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ResetpasswordComponent } from './my_components/resetpassword/resetpassword.component';
import { ItemDetailAdminComponent } from './my_components/item-detail-admin/item-detail-admin.component';
import { ItemDetailComponent } from './my_components/item-detail/item-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ResetpasswordComponent,
    ItemDetailAdminComponent,
    ItemDetailComponent
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
