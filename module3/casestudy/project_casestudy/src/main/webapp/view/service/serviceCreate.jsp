<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/12/2021
  Time: 1:58 PM
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
            <h3 class="text-center">Thêm Dịch Vụ</h3>
            <form action="/service?action=add" method="post">

                <div class="form-group">
                    <label for="service_code">Mã dịch vụ</label>
                    <input type="text" class="form-control" id="service_code" name="service_code" value="${serviceCreateList.serviceCode}" required>
                    <span>${messMSS}</span>
                </div>

                <div class="form-group">
                    <label for="service_type_id">Loại dịch vụ</label>
                    <select class="form-control" id="service_type_id" name="service_type_id" required>
                        <c:forEach var="loaidichvu" items="${serviceTypeList}">
                            <c:choose>
                                <c:when test="${loaidichvu.serviceTypeId == 1}">
                                    <option value="${loaidichvu.serviceTypeId}">${loaidichvu.serviceTypeName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${loaidichvu.serviceTypeId}">${loaidichvu.serviceTypeName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rent_type_id">Loại thuế</label>
                    <select class="form-control" id="rent_type_id" name="rent_type_id" required>
                        <c:forEach var="loaithue" items="${rentTypeList}">
                            <c:choose>
                                <c:when test="${loaithue.rentTypeId == 1}">
                                    <option value="${loaithue.rentTypeId}">${loaithue.rentTypeName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${loaithue.rentTypeId}">${loaithue.rentTypeName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="service_name">Tên dich vu</label>
                    <input type="text" class="form-control" id="service_name" name="service_name" required>
                </div>
                <div class="form-group">
                    <label for="service_area">Khu vuc diện tích dich vu</label>
                    <input type="text" class="form-control" id="service_area" name="service_area" required>
                </div>
                <div class="form-group">
                    <label for="service_cost">Chi phí dịch vu</label>
                    <input type="text" class="form-control" id="service_cost" name="service_cost" required>
                </div>
                <div class="form-group">
                    <label for="service_max_people">Số người tối đa</label>
                    <input type="text" class="form-control" id="service_max_people" name="service_max_people" required>
                </div>
                <div class="form-group">
                    <label for="standard_room">Kích thước phòng</label>
                    <input type="text" class="form-control" id="standard_room" name="standard_room" required>
                </div>
                <div class="form-group">
                    <label for="description_other_convenience">Mô tả sự tiện lợi</label>
                    <input type="text" class="form-control" id="description_other_convenience" name="description_other_convenience" required>
                </div>
                <div class="form-group">
                    <label for="pool_area">Diện thích bể bơi</label>
                    <input type="text" class="form-control" id="pool_area" name="pool_area" required>
                </div>
                <div class="form-group">
                    <label for="number_of_floors">Số tầng</label>
                    <input type="text" class="form-control" id="number_of_floors" name="number_of_floors" required>
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
