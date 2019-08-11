import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {UsuarioComponent} from './components/usuario/usuario.component';
import {RoutingModule} from './routing.module';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {HeaderComponent} from './components/header/header.component';
import {UsuariosService} from './services/usuarios.service';
import {FormsModule} from '@angular/forms';
import {UsuarioFormComponent} from './components/usuario/usuario-form/usuario-form.component';
import {UsuarioDetalheComponent} from './components/usuario/usuario-detalhe/usuario-detalhe.component';
import {NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {OperacaoService} from './services/operacao.service';
import {EnderecoService} from './services/endereco.service';
import {IConfig, NgxMaskModule} from 'ngx-mask';

export const options: Partial<IConfig> | (() => Partial<IConfig>) = {};

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    HeaderComponent,
    UsuarioFormComponent,
    UsuarioDetalheComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RoutingModule,
    RouterModule,
    FormsModule,
    NgbModalModule,
    NgxMaskModule.forRoot(options)
  ],
  providers: [
    UsuariosService,
    OperacaoService,
    EnderecoService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
