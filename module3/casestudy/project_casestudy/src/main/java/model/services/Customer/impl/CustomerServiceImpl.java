package model.services.Customer.impl;

import model.bean.Customer;
import model.repository.Customer.CustomerRepository;
import model.repository.Customer.impl.CustomerRepositoryImpl;
import model.services.Customer.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private final String VALIDATE_CUSTOMER_ID = "(KH)[-][\\d]{4}";
    private final String VALIDATE_CUSTOMER_PHONE ="^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    private final String VALIDATE_CUSTOMER_ID_CARD ="[\\d]{9}";
    private final String VALIDATE_CUSTOMER_DAY ="\\d{4}/(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])*";
    private final String VALIDATE_CUSTOMER_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    @Override
    public boolean saveCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public Map<String, String> saveCustomer1(Customer customer) {
        Map<String,String> map = new HashMap<>();
        boolean check = true;
        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        if(customer.getCustomerCode().equals("")){
            check = false;
            map.put("MSS","Ma khong duoc de trong");
        }else if(!validate(customer.getCustomerCode())){
            check = false;
            map.put("MSS","Ma khong dung dinh dang");
        }
        if(customer.getCustomerPhone().equals("")){
            check1= false;
            map.put("MSSPhone","Ma khong duoc de trong");
        }else if(!validate1(customer.getCustomerPhone())){
            check1 = false;
            map.put("MSSPhone","Số Điện thoại không đúng");
        }
        if(customer.getCustomerIdCard().equals("")){
            check2= false;
            map.put("MSSIdCart","CMND khong duoc bo trong");
        }else if(!validate2(customer.getCustomerIdCard())){
            check2 = false;
            map.put("MSSIdCart","CMND khong dung dinh dang");
        }
        if(customer.getCustomerIdCard().equals("")){
            check2= false;
            map.put("MSSIdCart","CMND khong duoc bo trong");
        }else if(!validate2(customer.getCustomerIdCard())){
            check2 = false;
            map.put("MSSIdCart","CMND khong dung dinh dang");
        }
//        if(customer.getCustomerBirthday().equals("")){
//            check3= false;
//            map.put("MSSDay","Ngày sinh khong duoc bo trong");
//        }else if(!validateDate(customer.getCustomerBirthday())){
//            check3 = false;
//            map.put("MSSDay","Ngày sinh khong dung dinh dang");
//        }
//        if(customer.getCustomerEmail().equals("")){
//            check4= false;
//            map.put("MSSEmail","Email khong duoc bo trong");
//        }else if(!validateEmail(customer.getCustomerEmail())){
//            check4 = false;
//            map.put("MSSEmail","Email khong dung dinh dang");
//        }
        if(check&&check1&&check2&&check3&&check4){
        customerRepository.saveCustomer(customer);
        }
        return map;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public boolean updateCustomer(int id, Customer customer) {
        return customerRepository.update(id,customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    // phương thức kiểm tra dữ liệu SOLID,
    public boolean validate(String customerCode){
        return customerCode.matches(VALIDATE_CUSTOMER_ID);
    }
    // phương thức kiểm tra dữ liệu SOLID,
    public boolean validate1(String customerPhone){
        return customerPhone.matches(VALIDATE_CUSTOMER_PHONE);
    }
    public boolean validate2(String customerIdCard){
        return customerIdCard.matches(VALIDATE_CUSTOMER_ID_CARD);
    }
    public boolean validate3(int soDuong){
        if(soDuong>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean validateDate(String customerDay){
        return customerDay.matches(VALIDATE_CUSTOMER_DAY);
    }
    public boolean validateEmail(String customerEmail){
        return customerEmail.matches(VALIDATE_CUSTOMER_EMAIL);
    }
}
