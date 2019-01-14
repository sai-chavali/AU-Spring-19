import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { TableDirective } from './table.directive';
import { DepartmentComponent } from './department/department.component';
import { AppRoutingModule } from './routing.module';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { EmployeeServiceService } from './employee-service.service';
import { EmployeedetailComponent } from './employeedetail/employeedetail.component';
import { CreateEmployeeFormComponent } from './create-employee-form/create-employee-form.component';
import { MustMatchDirective } from './must-match.directive';
import { ReactiveFormsModule } from '@angular/forms';
import { CreateEmployeeReactiveformComponent } from './create-employee-reactiveform/create-employee-reactiveform.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    TableDirective,
    DepartmentComponent,
    EmployeelistComponent,
    EmployeedetailComponent,
    CreateEmployeeFormComponent,
    MustMatchDirective,
    CreateEmployeeReactiveformComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
