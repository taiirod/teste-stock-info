import {Component, OnInit} from '@angular/core';
import {TitleService} from '../../services/title.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  title = '';

  constructor(private titleService: TitleService) {
  }

  ngOnInit() {
  }

}
