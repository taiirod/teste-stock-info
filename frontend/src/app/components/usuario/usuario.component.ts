import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../services/usuarios.service';
import {Usuario} from '../../model/usuario';
import {TitleService} from '../../services/title.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  todosUsuarios: Usuario[];

  constructor(private usuarioService: UsuariosService,
              private titleService: TitleService) {
  }

  ngOnInit() {
    this.buscarTodosUsuarios();
    this.titleService.changeTitleName('Lista de usuários');
  }

  buscarTodosUsuarios() {
    this.usuarioService.buscarTodosUsuarios().then(
      (resp: Usuario[]) => {
        this.todosUsuarios = resp;
      });
  }

}
