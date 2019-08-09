import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {EnderecoService} from '../../../services/endereco.service';
import {Endereco} from '../../../model/endereco';
import {Usuario} from '../../../model/usuario';
import {UsuariosService} from '../../../services/usuarios.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {

  usuario = new Usuario();
  endereco = new Endereco();
  cepNaoEncontrado = false;

  constructor(private enderecoService: EnderecoService,
              private usuarioService: UsuariosService,
              private router: Router) {
  }

  ngOnInit() {
  }

  novoUsuario(usuarioForm: NgForm) {
    this.usuario.nomeCompleto = usuarioForm.value.nomeCompleto;
    this.usuario.cpf = usuarioForm.value.cpf;
    this.usuario.telefone = usuarioForm.value.telefone;
    this.usuario.sexo = usuarioForm.value.sexo;
    this.usuario.email = usuarioForm.value.email;
    this.usuario.dataDeNascimento = usuarioForm.value.dataDeNascimento;

    console.log(usuarioForm.value);

    console.log('USUARIO');
    this.usuarioService.novo(this.usuario).subscribe(resp => {
      console.log(resp);
      if (resp != null) {
        this.router.navigate(['/usuarios']);
      }
    });
  }

  buscarPorCep(usuarioForm: NgForm) {
    const cep = usuarioForm.value.cep;
    if (cep.length >= 8) {
      this.enderecoService.buscarEndereco(cep)
        .then((endereco: Endereco) => {
          if (endereco != null) {

            this.endereco.cep = endereco.cep;
            this.endereco.logradouro = endereco.logradouro;
            this.endereco.localidade = endereco.localidade;
            this.endereco.bairro = endereco.bairro;
            this.endereco.uf = endereco.uf;

            this.usuario.endereco = this.endereco;

          } else {
            this.cepNaoEncontrado = true;
          }
        });
    }
  }
}
