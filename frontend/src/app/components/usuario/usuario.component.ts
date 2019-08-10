import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../services/usuarios.service';
import {Usuario} from '../../model/usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  todosUsuarios: Usuario[];

  constructor(private usuarioService: UsuariosService) {
  }

  ngOnInit() {
    this.buscarTodosUsuarios();
  }

  buscarTodosUsuarios() {
    this.usuarioService.buscarTodosUsuarios().then(
      (resp: Usuario[]) => {
        this.todosUsuarios = resp;
      });
  }

}
