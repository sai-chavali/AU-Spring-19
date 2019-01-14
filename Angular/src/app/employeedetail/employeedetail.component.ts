import { Component, OnInit, Input, OnChanges } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { EmployeedetailService }  from '../employeedetail.service'
@Component({
  selector: 'app-employeedetail',
  templateUrl: './employeedetail.component.html',
  styleUrls: ['./employeedetail.component.css']
})
export class EmployeedetailComponent implements OnInit, OnChanges {
  data: any;
  keys:any;
  @Input()id:Number;
  constructor(private detail:EmployeedetailService, private route: ActivatedRoute) {
      this.route.params.subscribe( params => this.id = params.id );
  }

  public getKeys(obj: any): any {
    if(obj){
      return Object.keys(obj);
    }
  }

  ngOnInit() {
    if(this.id){
      this.detail.getdetail(this.id).subscribe((details:any)=>{
        this.data = details
      });
    }
  }

  ngOnChanges(){
    this.ngOnInit()
  }

}
