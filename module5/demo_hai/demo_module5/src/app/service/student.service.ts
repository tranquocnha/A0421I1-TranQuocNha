import { Injectable } from '@angular/core';
import {Student} from "../model/student";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  public apiURL = "http://localhost:3000/students";
  studentList = [];
  constructor(private http: HttpClient) {
  }
  createStudent(value:Student):Observable<any> {
    return this.http.post<any>(this.apiURL,value)
  }
  findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.apiURL);
  }

  findById(id: number) {
    for(let studentObj of this.studentList) {
      // @ts-ignore
      if(studentObj.id == id) {
        return studentObj;
      }
    }
    return null;
  }
}
