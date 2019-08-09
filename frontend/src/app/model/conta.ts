import {Usuario} from './usuario';

export class Conta {
  id: number;
  usuario: Usuario;
  saldoContaNormal: number;
  saldoContaEventual: number;
  saldoTotalGeral: number;
}
