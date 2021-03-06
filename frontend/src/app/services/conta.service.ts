import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Conta} from '../model/conta';

@Injectable({
  providedIn: 'root'
})
export class ContaService {

  endpoint = 'http://localhost:8080/conta';

  constructor(private httpClient: HttpClient) {
  }

  buscarTodasContas() {
    return this.httpClient.get(this.endpoint).toPromise().then(resp => {
      return resp;
    });
  }

  buscarPorIdUsuario(id: number) {
    return this.httpClient.get(this.endpoint + '/usuario/' + id).toPromise().then(resp => {
      return resp;
    });
  }

  nova(conta: Conta) {
    return this.httpClient.post(this.endpoint, conta);
  }
}
