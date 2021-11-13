package controller;

import model.bean.Customer;
import model.services.*;
import model.services.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImlp();
    Service service = new ServiceImpl();
    ServiceType serviceType = new ServiceTypeImpl();
    RentTypeService rentTypeService = new RentTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                showCreateService(request,response);
                break;
            default:
                break;
        }
    }

    private void showCreateService(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/serviceCreate.jsp");
        request.setAttribute("serviceTypeList",serviceType.findAll());
        request.setAttribute("rentTypeList",rentTypeService.findAll());
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
                createService(request,response);
                break;
            default:
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String serviceCode = request.getParameter("service_code");
        String serviceName = request.getParameter("service_name");
        int serviceArea = Integer.parseInt(request.getParameter("service_area"));
        Double serviceCost = Double.parseDouble(request.getParameter("service_cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        Double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        int rentTypeId = Integer.parseInt(request.getParameter("rent_type_id"));
        model.bean.Service services = new model.bean.Service(serviceCode,serviceName,serviceArea,serviceCost
                ,serviceMaxPeople,standardRoom,descriptionOtherConvenience,poolArea
                ,numberOfFloors,serviceTypeId,rentTypeId);
        boolean check= service.saveService(services);
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
