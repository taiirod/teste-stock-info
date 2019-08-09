import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../../services/usuarios.service';
import {ActivatedRoute} from '@angular/router';
import {Usuario} from '../../../model/usuario';
import {ContaService} from '../../../services/conta.service';
import {Conta} from '../../../model/conta';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {OperacaoService} from '../../../services/operacao.service';
import {Operacao} from '../../../model/operacao';
import {TipoDeConta} from '../../../model/enum/tipo-de-conta.enum';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-usuario-detalhe',
  templateUrl: './usuario-detalhe.component.html',
  styleUrls: ['./usuario-detalhe.component.css']
})
export class UsuarioDetalheComponent implements OnInit {

  idUsuario: number;
  usuario = new Usuario();
  conta = new Conta();
  operacao = new Operacao();
  operacoes: Operacao[];

  constructor(private usuarioService: UsuariosService,
              private contaService: ContaService,
              private operacaoService: OperacaoService,
              private route: ActivatedRoute,
              private modalService: NgbModal) {
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

  buscarContaPorIdUsuario() {
    this.contaService.buscarPorIdUsuario(this.idUsuario)
      .then((conta: Conta) => {
        this.conta = conta;
        this.operacaoService.extratoDaConta(this.conta.id)
          .then((operacao: Operacao[]) => {
            this.operacoes = operacao;
          });
      });
  }


  abrirModalExtrato(modalExtrato) {
    this.modalService.open(modalExtrato, {scrollable: true});
  }

  abrirModalOperacao(modalSaque) {
    this.modalService.open(modalSaque, {size: 'xl'});
  }

  novaOperacao(operacaoForm: NgForm) {

    this.operacao.valor = operacaoForm.value.valor;
    this.operacao.tipoDeConta = operacaoForm.value.tipoDeConta;
    this.operacao.operacao = operacaoForm.value.operacao;

    if (operacaoForm.value.operacao === 'Depositar') {
      this.operacaoService.depositar(this.conta.id, this.operacao).then(resp => {
        console.log(resp);
      });

    } else if (operacaoForm.value.operacao === 'Sacar') {

    }
    console.log(this.operacao);
  }
}

