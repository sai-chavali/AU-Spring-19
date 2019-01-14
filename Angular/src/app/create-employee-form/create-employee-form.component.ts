import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee'
import { formArrayNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';

@Component({
  selector: 'app-create-employee-form',
  templateUrl: './create-employee-form.component.html',
  styleUrls: ['./create-employee-form.component.css']
})
export class CreateEmployeeFormComponent{

  model: any = {};

  onSubmit() {
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.model));
    this.model={}
  }
}

