import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  endpoint = 'https://viacep.com.br/ws/';

  constructor(private httpClient: HttpClient) {
  }

  buscarEndereco(cep: string) {
    return this.httpClient.get(this.endpoint + cep + '/json/').toPromise().then(endereco => {
      return endereco;
    });
  }
}
