package servlet;

import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletStudent", urlPatterns = {"/list"})
public class ServletStudent extends HttpServlet {
    List<Student> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Student(1,"minh",true,7));
        list.add(new Student(2,"anh",true,1));
        list.add(new Student(3,"hoang",true,2));
        list.add(new Student(4,"nha",true,3));
        list.add(new Student(6,"phuong",false,5));
        list.add(new Student(5,"nhat",true,10));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/home.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
