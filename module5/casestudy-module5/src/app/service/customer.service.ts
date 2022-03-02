import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../customer/customer';

const API = 'http://localhost:3000/customers';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(API, customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(API + '/' + id);
  }

  updateProduct(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(API + '/' + id, customer);
  }

  deleteProduct(id: number): Observable<Customer> {
    return this.http.delete<Customer>(API + '/' + id);
  }
}
