import {CustomerType} from '../model/customer-type';

export interface Customer {
  id: number;
  customerCode: string;
  nameCustomer: string;
  birthDate: string;
  gender: number;
  idCard: string;
  numberPhone: string;
  email: string;
  customerType: CustomerType;
  address: string;
}
