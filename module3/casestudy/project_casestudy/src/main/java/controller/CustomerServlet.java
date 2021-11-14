package controller;


import model.bean.Customer;
import model.services.Customer.CustomerService;
import model.services.CustomerType.CustomerTypeService;
import model.services.Customer.impl.CustomerServiceImpl;
import model.services.CustomerType.impl.CustomerTypeServiceImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImlp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "find":
                showFoundCustomer(request, response);
                break;
            case "update":
                showUpdateCustomer(request, response);
                break;
            case "add":
                showCreateCustomer(request,response);
                break;
            default:
                showCustomerList(request,response);
                break;
        }
    }

    private void showFoundCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("customer_name");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        request.setAttribute("customerList",customerService.findByName(name));
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerEdit.jsp");
        request.setAttribute("customerList",customerService.findById(id));
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerCreate.jsp");
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "add":
                createCustomer(request,response);
                break;
            default:
                break;
        }
    }


    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customer_id"));
        String customerCode = request.getParameter("customer_code");
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        String customerGender = request.getParameter("customer_gender");
        String customerIdCard = request.getParameter("customer_id_card");
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        Customer customer = new Customer(customerCode,customerName,customerBirthday,customerGender,customerIdCard,
                customerPhone,customerEmail,customerAddress,customerTypeId);
        boolean check= customerService.updateCustomer(id,customer);
        if (check){
            request.setAttribute("mess", "Sửa thành công");
        }else {
            request.setAttribute("mess", "Sửa thất bại");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.delete(id);
        request.setAttribute("message", "xóa thành công");
        showCustomerList(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerCode = request.getParameter("customer_code");
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        String customerGender = request.getParameter("customer_gender");
        String customerIdCard = request.getParameter("customer_id_card");
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        Customer customer = new Customer(customerCode,customerName,customerBirthday,customerGender,customerIdCard,
                customerPhone,customerEmail,customerAddress,customerTypeId);
        Map<String,String> map = customerService.saveCustomer1(customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("view/customer/customerCreate.jsp");
        if (map.isEmpty()){
            try {
                request.setAttribute("mess", "Thêm thành công");
                request.setAttribute("customerList",customerService.findAll());
                request.setAttribute("customerTypeList",customerTypeService.findAll());
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("messMSS",map.get("MSS"));
            request.setAttribute("messMSSPhone",map.get("MSSPhone"));
            request.setAttribute("messMSSIdCart",map.get("MSSIdCart"));
            request.setAttribute("customerCreateList",customer);
            request.setAttribute("customerTypeList",customerTypeService.findAll());
            try {
                requestDispatcher1.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
