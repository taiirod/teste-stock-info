import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UsuarioComponent} from './components/usuario/usuario.component';

const appRoutes: Routes = [
  {path: 'inicio', component: UsuarioComponent}
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
