<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/11/2021
  Time: 4:19 PM
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
            <h3 class="text-center">Thêm khách hành</h3>
            <form action="/customer?action=add" method="post">

                <div class="form-group">
                    <label for="customer_code">Mã khách hàng</label>
                    <input type="text" class="form-control" id="customer_code" name="customer_code" value="${customerCreateList.customerCode}" required>
                    <span style="color: red">${messMSS}</span>
                </div>

                <div class="form-group">
                    <label for="customer_type_id">Loại khách hàng</label>
                    <select class="form-control" id="customer_type_id" name="customer_type_id" required>
                        <c:forEach var="loaikhachang" items="${customerTypeList}">
                            <c:choose>
                                <c:when test="${loaikhachang.customerTypeId == 1}">
                                    <option value="${loaikhachang.customerTypeId}">${loaikhachang.customerTypeName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${loaikhachang.customerTypeId}">${loaikhachang.customerTypeName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="customer_name">Tên khách hàng</label>
                    <input type="text" class="form-control" id="customer_name" name="customer_name" required>
                </div>
                <div class="form-group">
                    <label for="customer_birthday">Ngày sinh nhật</label>
                    <input type="date" class="form-control" id="customer_birthday" name="customer_birthday" required>
                </div>
                <div class="form-group">
                    <label for="customer_birthday">Giới tính</label>
                    <input type="text" class="form-control" id="customer_gender" name="customer_gender" required>
                </div>
                <div class="form-group">
                    <label for="customer_id_card">Số CMND</label>
                    <input type="text" class="form-control" id="customer_id_card" name="customer_id_card" required>
                </div>
                <div class="form-group">
                    <label for="customer_id_card">Số điện thoại</label>
                    <input type="text" class="form-control" id="customer_phone" name="customer_phone" required>
                </div>
                <div class="form-group">
                    <label for="customer_email">Email</label>
                    <input type="text" class="form-control" id="customer_email" name="customer_email" required>
                </div>
                <div class="form-group">
                    <label for="customer_address">Địa chỉ</label>
                    <input type="text" class="form-control" id="customer_address" name="customer_address" required>
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
