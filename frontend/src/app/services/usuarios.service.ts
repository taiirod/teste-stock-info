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
    this.httpClient.get(this.endpoint)
      .toPromise()
      .then((resp: Usuario) => {
        console.log(resp);
        return resp;
      });
  }

  adicionarUsuario(usuario: Usuario) {
    this.httpClient.post(this.endpoint, usuario).toPromise().then(resp => {
      console.log(resp);
      return resp;
    });
  }

}
