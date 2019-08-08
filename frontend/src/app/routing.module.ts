import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UsuarioComponent} from './components/usuario/usuario.component';
import {InicioComponent} from './components/inicio/inicio.component';
import {UsuarioFormComponent} from './components/usuario/usuario-form/usuario-form.component';

const appRoutes: Routes = [
  {path: 'inicio', component: InicioComponent},
  {path: 'usuarios', component: UsuarioComponent},
  {path: 'usuario/:id', component: UsuarioFormComponent},
  {path: 'usuario/novo', component: UsuarioFormComponent},
  //{path: 'contas', component: ContaComponent}
  //{path: 'conta/:id', component: ContaComponent}
  //{path: 'conta/nova', component: ContaComponent}
  //{path: 'saque', component: SaqueComponent}
  //{path: 'deposito', component: DepositoComponent}

];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    )
    // other imports here
  ]
})
export class RoutingModule {
}
