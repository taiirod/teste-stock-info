import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Operacao} from '../model/operacao';

@Injectable({
  providedIn: 'root'
})
export class OperacaoService {

  endpoint = 'http://localhost:8080/operacao';

  constructor(private httpClient: HttpClient) {
  }

  extratoDaConta(id: number) {
    return this.httpClient.get(this.endpoint + '/' + id).toPromise().then(resp => {
      return resp;
    });
  }

  efetuarOperacao(idConta: number, operacao: Operacao) {
    return this.httpClient.put(this.endpoint + '/' + idConta, operacao).toPromise().then(resp => {
      return resp;
    });
  }

}
