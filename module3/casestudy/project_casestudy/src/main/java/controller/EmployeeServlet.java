package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.User;
import model.repository.DivisionRepository;
import model.services.DivisionService;
import model.services.EducationDegreeService;
import model.services.EmployeeService;
import model.services.PositionService;
import model.services.impl.DivisionServiceImpl;
import model.services.impl.EducationDegreeServiceImpl;
import model.services.impl.EmployeeServiceImpl;
import model.services.impl.PositionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    PositionService positionService = new PositionServiceImpl();
    EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                showCreateEmployee(request,response);
                break;
            default:
                showEmployeeList(request,response);
                break;
        }
    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/employeeCreate.jsp");
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("educationDegreeList",educationDegreeService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/employeeList.jsp");
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("educationDegreeList",educationDegreeService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
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
            case "delete":
                deleteEmployee(request, response);
                break;
            case "add":
                createEmployee(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        String userName = request.getParameter("userNameDelete");
        employeeService.deleteEmployee(id,userName);
        request.setAttribute("message", "xóa thành công");
        showEmployeeList(request,response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employeeName = request.getParameter("employee_name");
        String employeeBirthday = request.getParameter("employee_birthday");
        String employeeIdCard = request.getParameter("employee_id_card");
        Double employeeSalary = Double.parseDouble(request.getParameter("employee_salary"));
        String employeePhone = request.getParameter("employee_phone");
        String employeeEmail = request.getParameter("employee_email");
        String employeeAddress = request.getParameter("employee_address");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education_degree_id"));
        int divisionId = Integer.parseInt(request.getParameter("division_id"));
        String userName = request.getParameter("user_name");
        String passWork = request.getParameter("pass_work");
        Employee employee = new Employee(employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail,
                employeeAddress,positionId,educationDegreeId,divisionId,userName);
        User user = new User(userName,passWork);
        boolean check= employeeService.saveEmployee(employee,user);
        if (check){
            request.setAttribute("mess", "Thêm thành công");
        }else {
            request.setAttribute("mess", "Thêm thất bại");
        }
        // về alij trang list có kèm theo dữ liệu

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/employeeList.jsp");
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("educationDegreeList",educationDegreeService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
