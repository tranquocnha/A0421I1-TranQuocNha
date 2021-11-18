<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/15/2021
  Time: 3:59 PM
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
<a href="service?action=add"> Thêm dịch vụ</a><br>
<div class="container">
    <c:if test="${mess!=null}">
        <strong style="color: red">${mess}</strong>
    </c:if>
    <table id="page" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã dich vụ</th>
            <th scope="col">Tên dịch vụ</th>
            <th scope="col">Khu vuc diện tích dich vu</th>
            <th scope="col">Chi phí dịch vu</th>
            <th scope="col">Số người tối đa</th>
            <th scope="col">Kích thước phòng</th>
            <th scope="col">Mô tả sự tiện lợi</th>
            <th scope="col">Diện thích bể bơi</th>
            <th scope="col">Số tầng</th>
            <th scope="col">Loại dịch vụ</th>
            <th scope="col">Loại thuế</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="loop" var="dichvu" items="${serviceList}">
            <tr>
                <td>${loop.count}</td>
                <td>${dichvu.serviceCode}</td>
                <td>${dichvu.serviceName}</td>
                <td>${dichvu.serviceArea}</td>
                <td>${dichvu.serviceCost}</td>
                <td>${dichvu.serviceMaxPeople}</td>
                <td>${dichvu.standardRoom}</td>
                <td>${dichvu.descriptionOtherConvenience}</td>
                <td>${dichvu.poolArea}</td>
                <td>${dichvu.numberOfFloors}</td>
                <td>${dichvu.serviceTypeId}</td>
                <td>${dichvu.rentTypeId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#page').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })
</script>
</html>
