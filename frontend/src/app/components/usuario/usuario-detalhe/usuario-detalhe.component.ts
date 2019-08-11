import {Component, OnInit} from '@angular/core';
import {UsuariosService} from '../../../services/usuarios.service';
import {ActivatedRoute} from '@angular/router';
import {Usuario} from '../../../model/usuario';
import {ContaService} from '../../../services/conta.service';
import {Conta} from '../../../model/conta';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {OperacaoService} from '../../../services/operacao.service';
import {Operacao} from '../../../model/operacao';
import {NgForm} from '@angular/forms';
import {Endereco} from '../../../model/endereco';
import {EnderecoService} from '../../../services/endereco.service';
import {TitleService} from '../../../services/title.service';

@Component({
  selector: 'app-usuario-detalhe',
  templateUrl: './usuario-detalhe.component.html',
  styleUrls: ['./usuario-detalhe.component.css']
})
export class UsuarioDetalheComponent implements OnInit {

  idUsuario: number;
  usuario = new Usuario();
  endereco = new Endereco();
  conta = new Conta();
  operacao = new Operacao();
  operacoes: Operacao[];
  erro = false;

  constructor(private usuarioService: UsuariosService,
              private enderecoService: EnderecoService,
              private contaService: ContaService,
              private operacaoService: OperacaoService,
              private route: ActivatedRoute,
              private modalService: NgbModal,
              private titleService: TitleService) {
  }

  ngOnInit() {
    this.pegarId();
    this.buscarPorId();
    this.buscarContaPorIdUsuario();
    this.titleService.changeTitleName('Detalhes do usuário');
  }

  pegarId() {
    this.route.params.subscribe(id => {
      this.idUsuario = id.id;
    });
  }

  buscarPorId(): any {
    this.usuarioService.buscarPorId(this.idUsuario)
      .then((usuario: Usuario) => {
        this.usuario = usuario;
        return usuario;
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

  /* MODAIS */

  abrirModalDeposito(depositoModal) {
    const modal = this.modalService.open(depositoModal, {ariaLabelledBy: 'modal-basic-title'});
    modal.result.then(() => {
    }, () => {
      this.buscarContaPorIdUsuario();
    });
  }

  abrirModalSaque(saqueModal) {
    const modal = this.modalService.open(saqueModal, {ariaLabelledBy: 'modal-basic-title'});
    modal.result.then(() => {
    }, () => {
      this.buscarContaPorIdUsuario();
    });
  }

  abrirModalExtrato(modalExtrato) {
    this.modalService.open(modalExtrato, {scrollable: true});
  }

  abrirModalEditar(editarModal) {
    const modal = this.modalService.open(editarModal, {size: 'xl'});
    modal.result.then(() => {
    }, () => {
      this.buscarPorId();
    });
  }

  /* FORMS */
  deposito(opDepositoForm: NgForm) {

    this.operacao.valor = opDepositoForm.value.valor;
    this.operacao.tipoDeConta = opDepositoForm.value.tipoDeConta;
    this.operacao.operacao = 'Depositar';

    this.operacaoService.efetuarOperacao(this.conta.id, this.operacao)
      .then(resp => {
        if (resp != null) {
          this.modalService.dismissAll();
        }
      });
  }

  saque(opSaqueForm: NgForm) {
    this.operacao.valor = opSaqueForm.value.valor;
    this.operacao.tipoDeConta = opSaqueForm.value.tipoDeConta;
    this.operacao.operacao = 'Sacar';

    this.operacaoService.efetuarOperacao(this.conta.id, this.operacao)
      .then(resp => {
        if (resp != null) {
          this.modalService.dismissAll();
        }
      });
  }

  editar(editarForm: NgForm) {

    this.usuario.nomeCompleto = editarForm.value.nomeCompleto;
    this.usuario.cpf = editarForm.value.cpf;
    this.usuario.telefone = editarForm.value.telefone;
    this.usuario.sexo = editarForm.value.sexo;
    this.usuario.email = editarForm.value.email;
    this.usuario.dataDeNascimento = editarForm.value.dataDeNascimento;

    this.usuarioService.editar(this.usuario.id, this.usuario)
      .subscribe(usuarioResp => {
        if (usuarioResp != null) {
          this.modalService.dismissAll();
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
            this.endereco.numero = endereco.numero;
            this.endereco.localidade = endereco.localidade;
            this.endereco.bairro = endereco.bairro;
            this.endereco.uf = endereco.uf;

            this.usuario.endereco = this.endereco;

          }
        });
    }
  }
}

