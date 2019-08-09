import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UsuarioComponent} from './components/usuario/usuario.component';
import {InicioComponent} from './components/inicio/inicio.component';
import {UsuarioFormComponent} from './components/usuario/usuario-form/usuario-form.component';
import {ContaComponent} from './components/conta/conta.component';
import {ContaFormComponent} from './components/conta/conta-form/conta-form.component';
import {UsuarioDetalheComponent} from './components/usuario/usuario-detalhe/usuario-detalhe.component';

const appRoutes: Routes = [
  {
    path: 'inicio',
    component: InicioComponent,
    data: {
      title: 'Início'
    }
  },
  {
    path: 'usuarios',
    component: UsuarioComponent,
    data: {
      title: 'Usuários'
    }
  },
  {
    path: 'usuario/novo',
    component: UsuarioFormComponent,
    data: {
      title: 'Novo Usuário'
    }
  },
  {
    path: 'usuario/:id',
    component: UsuarioDetalheComponent,
    data: {
      title: 'Usuário'
    }
  },
  {
    path: 'contas',
    component: ContaComponent,
    data: {
      title: 'Início'
    }
  },
  {
    path: 'conta/nova',
    component: ContaFormComponent,
    data: {
      title: 'Início'
    }
  },
  {
    path: 'conta/:id',
    component: ContaComponent,
    data: {
      title: 'Início'
    }
  },

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
