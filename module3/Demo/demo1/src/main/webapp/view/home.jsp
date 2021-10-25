<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 10/25/2021
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chu</title>
</head>
<body>
<H1> Trang Chu</H1>
<h2> hien thi danh sach sinh vien</h2>
<table>
    <tr>
        <td>STT</td>
        <td>id</td>
        <td>ten</td>
        <td>gioitinh</td>
        <td>diem</td>
        <td> Xep loai</td>
    </tr>
    <c:forEach items="${list}" var="student" varStatus="staust">
        <tr>
            <td>${staust.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <c:if test="${student.sex}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.sex}">
                <td>Nu</td>
            </c:if>
            <td>${student.point}</td>
            <c:choose>
                <c:when test="${student.point < 5}">
                    <td>Yeu</td>
                </c:when>
                <c:when test="${student.point < 7}">
                    <td>trung binh</td>
                </c:when>
                <c:when test="${student.point <= 8}">
                    <td>Kha</td>
                </c:when>
                <c:otherwise>
                    <td>Gioi</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
