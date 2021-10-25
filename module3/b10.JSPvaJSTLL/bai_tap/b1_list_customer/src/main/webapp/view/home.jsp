<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 10/25/2021
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1> Trang Chu</H1>
<h2 style="align-content: center"> Danh sach khach hang</h2>
<table>
    <tr>
        <td>STT</td>
        <td>Tên</td>
        <td>Ngày Sinh</td>
        <td>Địa chỉ</td>
        <td>Img</td>
    </tr>
    <c:forEach items="${list}" var="student" varStatus="staust">
        <tr>
            <td>${staust.count}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <td><img style="width: auto;height: 50px" src="/img/${student.img}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
