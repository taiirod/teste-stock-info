import {Component, OnInit} from '@angular/core';
import {Conta} from '../../model/conta';
import {ContaService} from '../../services/conta.service';

@Component({
  selector: 'app-conta',
  templateUrl: './conta.component.html',
  styleUrls: ['./conta.component.css']
})
export class ContaComponent implements OnInit {

  todasContas: Conta[];

  constructor(private contaService: ContaService) {
  }

  ngOnInit() {
    this.buscarTodasContas();
  }

  buscarTodasContas() {
    this.contaService.buscarTodasContas().then(
      (resp: Conta[]) => {
        this.todasContas = resp;
      });
  }
}
