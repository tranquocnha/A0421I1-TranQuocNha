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
    List<Student> studentList = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        studentList.add(new Student("Mai Văn Hoàn","1983-08-20","Hà Nội","img1.jpg"));
        studentList.add(new Student("Nguyễn Văn Nam","1983-08-21","Bắc Giang","img2.jpg"));
        studentList.add(new Student("Nguyễn Thái Hòa","1983-08-22","Nam Định","img3.jpg"));
        studentList.add(new Student("Trần Đăng Khoa","1983-08-17","Hà Tây","img4.jpg"));
        studentList.add(new Student("Nguyễn Đình Thi","1983-08-19","Hà Nội","img5.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/home.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
