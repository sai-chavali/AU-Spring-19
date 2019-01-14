import { Component, OnInit, OnChanges, SimpleChange } from '@angular/core';

@Component({
  selector: 'app-employee', 
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  author = 'sai';
  show : boolean ;
  num:number;

  constructor(){}

  ngOnInit() {
    this.show = true;
    this.num = 10;
  }

}
