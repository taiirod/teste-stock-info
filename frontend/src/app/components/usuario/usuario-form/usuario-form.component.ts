import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {EnderecoService} from '../../../services/endereco.service';
import {Endereco} from '../../../model/endereco';
import {Usuario} from '../../../model/usuario';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {

  usuario = new Usuario();
  endereco = new Endereco();

  constructor(private enderecoService: EnderecoService) {
  }

  ngOnInit() {
  }

  novoUsuario(usuarioForm: NgForm) {
    console.log('Salvando.....');
    console.log(usuarioForm);
  }

  buscarPorCep(usuarioForm: NgForm) {
    const cep = usuarioForm.value.cep;
    if (cep.length >= 8) {
      this.enderecoService.buscarEndereco(cep).then((endereco: Endereco) => {
        if (endereco != null) {

          this.endereco.logradouro = endereco.logradouro;
          this.endereco.localidade = endereco.localidade;
          this.endereco.bairro = endereco.bairro;
          this.endereco.uf = endereco.uf;

          this.usuario.endereco = this.endereco;
          console.log('USUARIO', this.usuario);



          return usuarioForm;
        }
      });
    }
  }
}
