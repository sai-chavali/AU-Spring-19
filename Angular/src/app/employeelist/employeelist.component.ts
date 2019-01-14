import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service'

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit, OnChanges{
  users:any;
  id:Number;
  constructor(private empSer:EmployeeServiceService) { }

  @Input()num:Number;

  restrict = function(resp): void{
    if(this.num <= resp.length){
      this.users = resp.slice(0,this.num);
    }
    else{
      this.users = resp;
    }
  }

  clickable(id){
    this.id = id;
  }

  ngOnInit() {
    this.empSer.getUsers().subscribe((data:any) =>{
      this.restrict(data)
    })
  }

  ngOnChanges(){
    this.ngOnInit();
  }

}
