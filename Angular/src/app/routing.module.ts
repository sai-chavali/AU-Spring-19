import { NgModule } from '@angular/core';
import {RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import {EmployeedetailComponent} from './employeedetail/employeedetail.component'
import { DepartmentComponent } from './department/department.component';
import { CreateEmployeeFormComponent } from './create-employee-form/create-employee-form.component'
import {CreateEmployeeReactiveformComponent} from './create-employee-reactiveform/create-employee-reactiveform.component'

const routes:Routes = [
  {path:'employees',component:EmployeeComponent},
  {path:'departments',component:DepartmentComponent},
  {path:'employees/:id',component:EmployeedetailComponent},
  {path: 'employee/form', component: CreateEmployeeFormComponent},
  {path:'employee/reactform', component: CreateEmployeeReactiveformComponent}
]
@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ],
})

export class AppRoutingModule {}
