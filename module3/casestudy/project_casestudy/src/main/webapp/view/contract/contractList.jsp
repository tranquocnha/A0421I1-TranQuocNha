<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/15/2021
  Time: 5:02 PM
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
<a href="contract?action=add"> Thêm hợp đồng</a><br>
<div class="container">
    <c:if test="${mess!=null}">
        <strong style="color: red">${mess}</strong>
    </c:if>
    <table id="page" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Ngày Bắt Đầu Hợp Đồng</th>
            <th scope="col">Ngày Kết Thúc Hợp Đồng</th>
            <th scope="col">Tiền quỹ hợp đồng</th>
            <th scope="col">Hợp Đồng Tổng Số Tiền</th>
            <th scope="col">Nhân viên Kí Hợp Đồng</th>
            <th scope="col">Khách Hàng Kí Hợp Đồng</th>
            <th scope="col">Dịch vu Hợp Đồng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="loop" var="hopdong" items="${contractList}">
            <tr>
                <td>${loop.count}</td>
                <td>${hopdong.contractStartDate}</td>
                <td>${hopdong.contractEndDate}</td>
                <td>${hopdong.contractDeposit}</td>
                <td>${hopdong.contractTotalMoney}</td>
                <td>${hopdong.employeeId}</td>
                <td>${hopdong.customerId}</td>
                <td>${hopdong.serviceId}</td>
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
</body>
</html>
