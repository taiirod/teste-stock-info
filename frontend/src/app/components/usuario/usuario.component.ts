import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../services/usuarios.service';
import {Usuario} from '../../model/usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  usuarios: Usuario[];

  constructor(private usuarioService: UsuariosService) {
  }

  ngOnInit() {
    this.usuarioService.buscarTodosUsuarios().subscribe(
      (resp: Usuario[]) => {
      this.usuarios = resp;
      console.log(this.usuarios);
    });
  }

}
