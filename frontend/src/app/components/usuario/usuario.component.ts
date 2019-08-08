import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../services/usuarios.service';
import {Usuario} from '../../model/usuario';
import {Endereco} from '../../model/endereco';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  todosUsuarios: Array<Usuario> = new Array<Usuario>();

  usuario: Usuario;

  constructor(private usuarioService: UsuariosService) {
  }

  ngOnInit() {
    this.buscarTodosUsuarios();
  }

  buscarTodosUsuarios() {
    this.usuarioService.buscarTodosUsuarios().subscribe(resp => {
      this.todosUsuarios = resp;
    });
  }

  novoUsuario(usuario) {
    console.log(usuario)
    this.usuarioService.novo(usuario).subscribe(resp => {
      console.log(resp);
    });
  }

}
