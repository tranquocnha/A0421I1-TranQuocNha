package controller;


import model.bean.Customer;
import model.bean.CustomerType;
import model.services.CustomerService;
import model.services.CustomerTypeService;
import model.services.impl.CustomerServiceImpl;
import model.services.impl.CustomerTypeServiceImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
        boolean check= customerService.saveCustomer(customer);
        if (check){
            request.setAttribute("mess", "Thêm thành công");
        }else {
            request.setAttribute("mess", "Thêm thất bại");
        }
        // về alij trang list có kèm theo dữ liệu

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
}
