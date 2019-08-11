import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UsuarioComponent} from './components/usuario/usuario.component';
import {UsuarioFormComponent} from './components/usuario/usuario-form/usuario-form.component';
import {UsuarioDetalheComponent} from './components/usuario/usuario-detalhe/usuario-detalhe.component';

const appRoutes: Routes = [

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
    path: '**',
    redirectTo: 'usuarios'
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
