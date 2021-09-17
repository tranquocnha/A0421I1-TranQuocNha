package cassestudy.services.Impl;

import cassestudy.data.ReadAndWrite;
import cassestudy.models.Customer;
import cassestudy.models.Employee;
import cassestudy.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
//    static {
//        employeeList = new ArrayList<>();
//        employeeList.add(new Employee(1,"Nha",21,"DaNang","Nam",935221133,
//                "luytlong@gmail.com","giam doc",2000000));
//        employeeList.add(new Employee(2,"Hau",21,"DaNang","Nam",935221133,
//                "luytlong@gmail.com","giam doc",2000000));
//    }
    public Employee isEmployee(String employeeCode) {
        for (Employee employees : employeeList) {
            if (employees.getId().equals(employeeCode)) {
                return employees;
            }
        }
        return null;
    }

    @Override
    public void display() {
        employeeList = (List<Employee>) ReadAndWrite.read("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\employee.csv");
        for(Employee employee: employeeList){
            System.out.println(employee.toString());
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
        System.out.println("Nhap chuc vu: ");
        String level = scanner.nextLine();
        System.out.println("Nhap luong: ");
        int salary = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(id,name,age,address,gender,phoneNumber,email,level,salary);
        employeeList.add(employee);

        ReadAndWrite.write(employeeList, "D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\employee.csv");
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
        Employee employee = isEmployee(employeeCode);
        if (employee != null) {
            System.out.println("Chon:  ");
            System.out.println("1. Sdt:  ");
            System.out.println("2. Email: ");
            System.out.println("3. Chuc vu: ");
            System.out.println("4. Luong: ");
            System.out.println("5.Tro lai");
            int choice = 1;
            int phoneNumber;
            String email;
            while (choice != 0) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Nhap sai chuc nang, nhap lai: ");
                }
                switch (choice) {
                    case 1:
                        System.out.println("Enter new TelephoneNumber:");
                        phoneNumber = Integer.parseInt(scanner.nextLine());
                        employee.setPhoneNumber(phoneNumber);
                        display();
                        break;
                    case 2:
                        System.out.println("Email moi:");
                        email = scanner.nextLine();
                        employee.setEmail(email);
                        display();
                        break;
                    case 3:
                        String position;
                        System.out.println("Chuc vu moi: ");
                        try {
                            position = scanner.nextLine();
                            employee.setPosition(position);
                        } catch (NumberFormatException e) {
                            System.out.println("Import bad format, please enter back");
                        }
                        display();
                        break;
                    case 4:
                        int salary = 0;
                        System.out.println("Luong moi: ");
                        try {
                            salary = Integer.parseInt(scanner.nextLine());
                            employee.setSalary(salary);
                        } catch (NumberFormatException e) {
                            System.out.println("Import bad format, please enter back");
                        }
                        display();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice! Exit!");
                }
            }
        } else {
            System.out.println("id not found");
            edit();
        }
        ReadAndWrite.write(employeeList, "D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\employee.csv");
    }

    @Override
    public void delete() {
        System.out.println("Nhap id nhan vien can xoa: ");
        String idEmployee = scanner.nextLine();
        Employee employee = isEmployee(idEmployee);
        employeeList.remove(employee);
        ReadAndWrite.write(employeeList,"D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\employee.csv");
        System.out.println("Xoa thanh cong");
    }
}
