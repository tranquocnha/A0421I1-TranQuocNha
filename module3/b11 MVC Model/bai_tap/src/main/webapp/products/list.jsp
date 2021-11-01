<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/1/2021
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer</h1>
<p>
    <a href="/list?action=create">Create new Products</a>
</p>
<p>
    <a href="/list?action=find">Find Products</a>
</p>
<table border="1">
    <tr>
        <td>STT</td>
        <td>Tên Sản Phẩm</td>
        <td>Giá Sản Phẩm</td>
        <td>Mô tả Sản Phẩm</td>
        <td>Nhà Sản Xuất</td>
        <td>Hoạt Động</td>
    </tr>
    <c:forEach items="${requestScope['products']}" var="product" varStatus="stasus" >
        <tr>
            <td>${stasus.count}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.productDescribe}</td>
            <td>${product.producer}</td>
            <td>
                <a href="/list?action=view&id=${product.getId()}"><span>view</span></a>
                <a href="/list?action=edit&id=${product.getId()}"><span style="color: blue">edit</span></a>
                <a href="/list?action=delete&id=${product.getId()}"><span style="color: red">delete</span></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
