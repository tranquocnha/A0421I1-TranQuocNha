package cassestudy.services.Impl;

import cassestudy.data.ReadAndWrite;
import cassestudy.models.Customer;
import cassestudy.models.Employee;
import cassestudy.services.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public Customer isCustomer(String customerCode) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(customerCode)) {
                return customer;
            }
        }
        return null;
    }
    public List<Customer> getCustomerList() {
        return customerList;
    }
    @Override
    public void display() {
        customerList = (List<Customer>) ReadAndWrite.read("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\customer.csv");
        for(Customer customer: customerList){
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNes() {
        System.out.println("Nhap id: ");
        String id = scanner.nextLine();
        System.out.println("Nhap ten: ");
        String name =scanner.nextLine();
        System.out.println("Nhap tuoi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        System.out.println("Nhap gioi tinh");
        String gender = scanner.nextLine();
        System.out.println("Nhap sdt: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap email: ");
        String email = scanner.nextLine();
        System.out.println("Nhap loai khach hang");
        String typeCustomer = scanner.nextLine();
        Customer customer = new Customer(id,name,age,address,gender,phoneNumber,email,typeCustomer);
        customerList.add(customer);
        ReadAndWrite.write(customerList,"D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\customer.csv");
    }

    @Override
    public void edit() {
        System.out.println("Nhap ma vien can sua: ");
        String employeeCode="";
        try {
            employeeCode = scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Sai ma, nhap lai: ");
        }
        Customer customer = isCustomer(employeeCode);
        if (customer != null) {
            System.out.println("Chon:  ");
            System.out.println("1. Sdt:  ");
            System.out.println("2. Email: ");
            System.out.println("3. Loai khach hang: ");
            System.out.println("4.Tro lai");
            int choice = 1;
            while (choice != 0) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Nhap sai chuc nang, nhap lai: ");
                }
                switch (choice) {
                    case 1:
                        System.out.println("Nhap so dien thoai moi : ");
                        int phone = Integer.parseInt(scanner.nextLine());
                        customer.setPhoneNumber(phone);
                        display();
                        break;
                    case 2:
                        System.out.println("Nhap email moi : ");
                        String email = scanner.nextLine();
                        customer.setEmail(email);
                        display();
                        break;
                    case 3:
                        System.out.println("Nhap loai khach hang : ");
                        String typeCustomer = scanner.nextLine();
                        customer.setTypeCustomer(typeCustomer);
                        display();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice! Exit!");
                }
            }
        } else {
            System.out.println("id not found");
            edit();
        }
        ReadAndWrite.write(customerList, "D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\customer.csv");
    }

    @Override
    public void delete() {

    }
}
