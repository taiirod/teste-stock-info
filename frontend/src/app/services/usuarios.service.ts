import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Usuario} from '../model/usuario';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  endpoint = 'http://localhost:8080/usuario';

  constructor(private httpClient: HttpClient) {
  }

  buscarTodosUsuarios() {
    return this.httpClient.get<Usuario[]>(this.endpoint);
  }

  novo(usuario: Usuario) {
    return this.httpClient.post(this.endpoint, usuario);
  }

  delete(id) {
    return this.httpClient.delete(this.endpoint + '/' + id);
  }

}
