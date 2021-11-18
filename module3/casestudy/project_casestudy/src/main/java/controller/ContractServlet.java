package controller;

import model.bean.Contract;
import model.services.Contract.ContractService;
import model.services.Contract.impl.ContractServiceImpl;
import model.services.Customer.CustomerService;
import model.services.Customer.impl.CustomerServiceImpl;
import model.services.CustomerType.CustomerTypeService;
import model.services.CustomerType.impl.CustomerTypeServiceImlp;
import model.services.Employee.EmployeeService;
import model.services.Employee.impl.EmployeeServiceImpl;
import model.services.Service.Service;
import model.services.Service.impl.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImlp();
    ContractService contractService = new ContractServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    Service service = new ServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                showCreateContract(request,response);
                break;
            default:
                showContractList(request,response);
                break;
        }
    }

    private void showContractList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/contractList.jsp");
        request.setAttribute("contractList",contractService.findAll());
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("serviceList",service.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/contractCreate.jsp");
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("serviceList",service.findAll());
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
            case "add":
                createContract(request,response);
                break;
            default:
                break;
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String contractStartDate = request.getParameter("contract_start_date");
        String contractEndDate = request.getParameter("contract_end_date");
        Double contractDeposit = Double.parseDouble(request.getParameter("contract_deposit"));
        Double contractTotalMoney = Double.parseDouble(request.getParameter("contract_total_money"));
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        int serviceId = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(contractStartDate,contractEndDate,contractDeposit,contractTotalMoney,
                employeeId,customerId,serviceId);
        boolean check= contractService.saveContract(contract);
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
