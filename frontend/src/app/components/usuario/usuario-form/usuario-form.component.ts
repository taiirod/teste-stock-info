import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  novoUsuario(usuarioForm: NgForm) {
    console.log('Salvando.....');
    console.log(usuarioForm);
  }
}
