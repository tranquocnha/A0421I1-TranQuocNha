<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/1/2021
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/list">Back to product list</a>
</p>
<table>
    <tr>
        <td>Tên sản phẩm: </td>
        <td>${requestScope["product"].productName}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"].productPrice}</td>
    </tr>
    <tr>
        <td>Mô tả: </td>
        <td>${requestScope["product"].productDescribe}</td>
    </tr>
    <tr>
        <td>Nhà sản phẩm: </td>
        <td>${requestScope["product"].producer}</td>
    </tr>
</table>
</body>
</html>
