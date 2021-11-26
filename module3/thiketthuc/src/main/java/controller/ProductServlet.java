package controller;

import model.bean.Product;
import model.services.Category.CategoryService;
import model.services.Category.impl.CategoryServiceImpl;
import model.services.ProductService;
import model.services.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "find":
                showFoundProduct(request, response);
                break;
            case "update":
                showUpdateProduct(request, response);
                break;
            case "add":
                showCreateProduct(request,response);
                break;
            default:
                showProductList(request,response);
                break;
        }
    }

    private void showFoundProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("product_name");
        String productColor = request.getParameter("product_color");
        String productAddress = request.getParameter("product_address");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/productList.jsp");
        request.setAttribute("productList",productService.findByNameAndColorAndAddress(productName,productColor,productAddress));
        request.setAttribute("categoryList",categoryService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/productEdit.jsp");
        request.setAttribute("productList",productService.findById(id));
        request.setAttribute("categoryList",categoryService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/productCreate.jsp");
        request.setAttribute("categoryList",categoryService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/productList.jsp");
        request.setAttribute("productList",productService.findAll());
        request.setAttribute("categoryList",categoryService.findAll());
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
                deleteProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "add":
                createProduct(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        productService.delete(id);
        request.setAttribute("message", "xóa thành công");
        showProductList(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        String productName = request.getParameter("product_name");
        Double productPrice = Double.parseDouble(request.getParameter("product_price"));
        int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
        String productColor = request.getParameter("product_color");
        String productAddress = request.getParameter("product_address");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Product product = new Product(productId,productName,productPrice,productQuantity,productColor,productAddress,categoryId);
        boolean check= productService.updateProduct(productId,product);
        if (check){
            request.setAttribute("mess", "Sửa thành công");
        }else {
            request.setAttribute("mess", "Sửa thất bại");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/productList.jsp");
        request.setAttribute("productList",productService.findAll());
        request.setAttribute("categoryList",categoryService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("product_name");
        Double productPrice = Double.parseDouble(request.getParameter("product_price"));
        int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
        String productColor = request.getParameter("product_color");
        String productAddress = request.getParameter("product_address");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Product product = new Product(productName,productPrice,productQuantity,productColor,productAddress,categoryId);
        boolean check= productService.saveProduct(product);
        if (check){
            request.setAttribute("mess", "Thêm thành công");
        }else {
            request.setAttribute("mess", "Thêm thất bại");
        }
        // về alij trang list có kèm theo dữ liệu

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/productList.jsp");
        request.setAttribute("productList",productService.findAll());
        request.setAttribute("categoryList",categoryService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
