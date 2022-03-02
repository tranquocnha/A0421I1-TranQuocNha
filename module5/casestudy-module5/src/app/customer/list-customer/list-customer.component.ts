import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  public customer: Customer[] = [];
  p: number  = 1;
  filter: any;

  constructor(private customerService: CustomerService,
              // private matDialog: MatDialog,
              // private snackBar: MatSnackBar
                ) {
  }

  deleteRowData(customer) {
    this.customerService.deleteProduct(customer.id).subscribe(() => {
        this.getAll();
      }
    );
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerService.getAll().subscribe(next => {
      this.customer = next;
      // console.log(this.customers);
    });
  }
}
