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
      }
    ]
  };

  constructor() {
  }

  ngOnInit() {
  }

}
