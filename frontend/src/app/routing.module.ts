import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UsuarioComponent} from './components/usuario/usuario.component';
import {InicioComponent} from './components/inicio/inicio.component';
import {UsuarioFormComponent} from './components/usuario/usuario-form/usuario-form.component';
import {ContaComponent} from './components/conta/conta.component';
import {ContaFormComponent} from './components/conta/conta-form/conta-form.component';
import {UsuarioDetalheComponent} from './components/usuario/usuario-detalhe/usuario-detalhe.component';

const appRoutes: Routes = [
  {path: 'inicio', component: InicioComponent},
  {path: 'usuarios', component: UsuarioComponent},
  {path: 'usuario/novo', component: UsuarioFormComponent},
  {path: 'usuario/:id', component: UsuarioDetalheComponent},
  {path: 'contas', component: ContaComponent},
  {path: 'conta/:id', component: ContaComponent},
  {path: 'conta/nova', component: ContaFormComponent},
  //{path: 'saque', component: SaqueComponent},
  //{path: 'deposito', component: DepositoComponent},

];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: false} // <-- debugging purposes only
    )
    // other imports here
  ]
})
export class RoutingModule {
}
