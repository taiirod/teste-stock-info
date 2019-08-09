import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ContaService} from '../../../services/conta.service';
import {UsuariosService} from '../../../services/usuarios.service';
import {Usuario} from '../../../model/usuario';
import {Conta} from '../../../model/conta';
import {Router} from '@angular/router';

@Component({
  selector: 'app-conta-form',
  templateUrl: './conta-form.component.html',
  styleUrls: ['./conta-form.component.css']
})
export class ContaFormComponent implements OnInit {

  todosUsuarios: Usuario[];
  usuario = new Usuario();
  conta = new Conta();

  constructor(private contaService: ContaService,
              private usuariosService: UsuariosService,
              private router: Router) {
  }

  ngOnInit() {
    this.buscarTodosUsuarios();
  }

  buscarTodosUsuarios() {
    this.usuariosService.buscarTodosUsuarios().then(
      (resp: Usuario[]) => {
        console.log(resp);
        this.todosUsuarios = resp;
      });
  }

  novaConta(contaForm: NgForm) {
    this.usuario.id = contaForm.value.usuario;
    this.conta.usuario = this.usuario;
    this.conta.saldoContaEventual = 0;
    this.conta.saldoContaNormal = 0;
    this.contaService.nova(this.conta).subscribe(resp => {
      console.log(resp);
      if (resp != null) {
        this.router.navigate(['/contas']);
      }
    });
  }
}
