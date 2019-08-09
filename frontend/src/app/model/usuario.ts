import {Endereco} from './endereco';


export class Usuario {
  id: number;
  nomeCompleto: string;
  cpf: string;
  sexo: string;
  idade: number;
  dataDeNascimento: string;
  email: string;
  telefone: string;
  endereco: Endereco;
}
