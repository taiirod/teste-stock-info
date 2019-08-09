import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Usuario} from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  endpoint = 'http://localhost:8080/usuario';

  constructor(private httpClient: HttpClient) {
  }

  buscarTodosUsuarios() {
    return this.httpClient.get(this.endpoint).toPromise().then(resp => {
      return resp;
    });
  }

  buscarPorId(id: number) {
    return this.httpClient.get(this.endpoint + '/' + id).toPromise().then(resp => {
      console.log(resp);
      return resp;
    });
  }

  novo(usuario: Usuario) {
    return this.httpClient.post(this.endpoint, usuario);
  }

  delete(id) {
    return this.httpClient.delete(this.endpoint + '/' + id);
  }

}
