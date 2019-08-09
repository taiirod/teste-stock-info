import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../../services/usuarios.service';
import {ActivatedRoute} from '@angular/router';
import {Usuario} from '../../../model/usuario';
import {ContaService} from '../../../services/conta.service';
import {Conta} from '../../../model/conta';

@Component({
  selector: 'app-usuario-detalhe',
  templateUrl: './usuario-detalhe.component.html',
  styleUrls: ['./usuario-detalhe.component.css']
})
export class UsuarioDetalheComponent implements OnInit {

  idUsuario: number;
  usuario = new Usuario();
  conta = new Conta();

  constructor(private usuarioService: UsuariosService,
              private contaService: ContaService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.pegarId();
    this.buscarPorId();
    this.buscarContaPorIdUsuario();
  }

  pegarId() {
    this.route.params.subscribe(id => {
      this.idUsuario = id.id;
    });
  }

  buscarPorId() {
    this.usuarioService.buscarPorId(this.idUsuario)
      .then((usuario: Usuario) => {
        console.log(usuario);
        this.usuario = usuario;
      });
  }

  buscarContaPorIdUsuario(){
    this.contaService.buscarPorIdUsuario(this.idUsuario)
      .then((conta: Conta) => {
      this.conta = conta;
    });
  }

}

