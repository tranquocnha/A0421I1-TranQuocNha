<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/22/2021
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row bg-white p-lg-5">
        <div class="col-lg-12">
            <h3 class="text-center">Thêm San Pham</h3>
            <form action="/product?action=add" method="post">

                <div class="form-group">
                    <label for="product_name">Name</label>
                    <input type="text" class="form-control" id="product_name" name="product_name" required>
                </div>
                <div class="form-group">
                    <label for="product_name">Price</label>
                    <input type="text" class="form-control" id="product_price" name="product_price" required>
                </div>
                <div class="form-group">
                    <label for="product_quantity">Quantity</label>
                    <input type="text" class="form-control" id="product_quantity" name="product_quantity" required>
                </div>
                <div class="form-group">
                    <label for="product_color">Color</label>
                    <input type="text" class="form-control" id="product_color" name="product_color" required>
                </div>
                <div class="form-group">
                    <label for="product_address">Description</label>
                    <textarea type="textarea" class="form-control" id="product_address" name="product_address" required></textarea>
                </div>
                <div class="form-group">
                    <label for="category_id">Category</label>
                    <select class="form-control" id="category_id" name="category_id" required>
                        <c:forEach var="danhmuc" items="${categoryList}">
                            <c:choose>
                                <c:when test="${danhmuc.categoryId == 1}">
                                    <option value="${danhmuc.categoryId}">${danhmuc.categoryName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${danhmuc.categoryId}">${danhmuc.categoryName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Lưu</button>
                <button type="button" class="btn btn-success">
                    <a href="/" class="text-white">Quay Lại</a>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
