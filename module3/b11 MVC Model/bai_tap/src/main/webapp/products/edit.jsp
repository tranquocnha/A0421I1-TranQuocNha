<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/1/2021
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/list">Back to customer list</a>
</p>
<form>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Tên sản phẩm: </td>
                <td><input type="text" name="name_product" id="name_product" value="${requestScope["product"].productName}"></td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].productPrice}"></td>
            </tr>
            <tr>
                <td>Mô tả: </td>
                <td><input type="text" name="product_describe" id="product_describe" value="${requestScope["product"].productDescribe}"></td>
            </tr>
            <tr>
                <td>Nhà sản phẩm: </td>
                <td><input type="text" name="product" id="product" value="${requestScope["product"].producer}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
