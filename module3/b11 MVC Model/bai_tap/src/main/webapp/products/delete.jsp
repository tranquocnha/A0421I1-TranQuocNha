<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/1/2021
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/list">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/list">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
