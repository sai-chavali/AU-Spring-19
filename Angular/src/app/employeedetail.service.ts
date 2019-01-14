import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class EmployeedetailService {

  constructor(private http:HttpClient) { }

  getdetail(id:any){
      return this.http.get('https://jsonplaceholder.typicode.com/users/' + id)
  }
}

