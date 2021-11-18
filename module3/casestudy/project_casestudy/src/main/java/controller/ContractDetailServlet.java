package controller;

import model.bean.ContractDetail;
import model.repository.ContractDetail.impl.ContractDetailRepositoryImpl;
import model.services.ContractDetail.ContractDetailService;
import model.services.ContractDetail.impl.ContractDetailServiceImpl;
import model.services.Customer.CustomerService;
import model.services.Customer.impl.CustomerServiceImpl;
import model.services.CustomerType.CustomerTypeService;
import model.services.CustomerType.impl.CustomerTypeServiceImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImlp();
    ContractDetailService contractDetailService = new ContractDetailServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                showCreateContractDetail(request,response);
                break;
            default:
                showContractDetailList(request,response);
                break;
        }
    }

    private void showContractDetailList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contractDetail/contractDetailList.jsp");
        request.setAttribute("contractDetailList",contractDetailService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateContractDetail(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contractDetail/contracDetailCreate.jsp");
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
                createContractDetail(request,response);
                break;
            default:
                break;
        }
    }
    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contractId = Integer.parseInt(request.getParameter("contract_id"));
        int attachServiceId = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contractId,attachServiceId,quantity);
        boolean check = contractDetailService.saveContractDetail(contractDetail);
        if (check){
            request.setAttribute("mess", "Thêm thành công");
        }else {
            request.setAttribute("mess", "Thêm thất bại");
        }
        // về alij trang list có kèm theo dữ liệu

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contractDetail/contractDetailList.jsp");
        request.setAttribute("contractDetailList",contractDetailService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
