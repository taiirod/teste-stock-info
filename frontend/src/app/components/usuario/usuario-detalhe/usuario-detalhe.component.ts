import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../../services/usuarios.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-usuario-detalhe',
  templateUrl: './usuario-detalhe.component.html',
  styleUrls: ['./usuario-detalhe.component.css']
})
export class UsuarioDetalheComponent implements OnInit {

  idUsuario: number;

  constructor(private usuarioService: UsuariosService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
   // this.pegarId();
    this.buscarPorId();
  }

  pegarId() {
    this.route.params.subscribe(id => {
      this.idUsuario = id.id;
    });
  }

  buscarPorId() {
    this.usuarioService.buscarPorId(1).then(usuario => {
      console.log(usuario);
    });
  }

}

