import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import {RoutingModule} from './routing.module';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import {UsuariosService} from './services/usuarios.service';
import {FormsModule} from '@angular/forms';
import { InicioComponent } from './components/inicio/inicio.component';
import { UsuarioFormComponent } from './components/usuario/usuario-form/usuario-form.component';
import { ContaComponent } from './components/conta/conta.component';
import { ContaFormComponent } from './components/conta/conta-form/conta-form.component';
import { UsuarioDetalheComponent } from './components/usuario/usuario-detalhe/usuario-detalhe.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    HeaderComponent,
    InicioComponent,
    UsuarioFormComponent,
    ContaComponent,
    ContaFormComponent,
    UsuarioDetalheComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RoutingModule,
    RouterModule,
    FormsModule
  ],
  providers: [
    UsuariosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
