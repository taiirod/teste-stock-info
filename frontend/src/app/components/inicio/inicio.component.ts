import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {


  menuItems = {
    main: [
      {
        route: 'usuarios',
        label: 'Usuários',
        icon: 'fa fa-user fa-4x'
      },
      {
        route: 'contas',
        label: 'Contas',
        icon: ''
      },
      {
        route: 'saques',
        label: 'Histórico de saques',
        icon: 'fa fa-money fa-4x'
      },
      {
        route: 'depositos',
        label: 'Histórico de depositos',
        icon: 'fa fa-credit-card-alt fa-4x'
      }

    ]
  };

  constructor() {
  }

  ngOnInit() {
  }

}
