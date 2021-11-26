<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/12/2021
  Time: 8:35 PM
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
            <h3 class="text-center">Thêm Nhân Viên</h3>
            <form action="/employee?action=add" method="post">
                <div class="form-group">
                    <label for="employee_name">Tên Nhân viên</label>
                    <input type="text" class="form-control" id="employee_name" name="employee_name" required>
                </div>
                <div class="form-group">
                    <label for="employee_birthday">Ngày Sinh</label>
                    <input type="date" class="form-control" id="employee_birthday" name="employee_birthday" required>
                </div>
                <div class="form-group">
                    <label for="employee_id_card">Số chứng minh</label>
                    <input type="text" class="form-control" id="employee_id_card" name="employee_id_card" required>
                </div>
                <div class="form-group">
                    <label for="employee_salary">Lương nhân viên</label>
                    <input type="text" class="form-control" id="employee_salary" name="employee_salary" required>
                </div>
                <div class="form-group">
                    <label for="employee_phone">Số điện thoại</label>
                    <input type="text" class="form-control" id="employee_phone" name="employee_phone" required>
                </div>
                <div class="form-group">
                    <label for="employee_email">Email</label>
                    <input type="text" class="form-control" id="employee_email" name="employee_email" required>
                </div>
                <div class="form-group">
                    <label for="employee_address">Địa chỉ</label>
                    <input type="text" class="form-control" id="employee_address" name="employee_address" required>
                </div>
                <div class="form-group">
                    <label for="position_id">Vị trí</label>
                    <select class="form-control" id="position_id" name="position_id" required>
                        <c:forEach var="vitri" items="${positionList}">
                            <c:choose>
                                <c:when test="${vitri.positionId == 1}">
                                    <option value="${vitri.positionId}">${vitri.positionName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${vitri.positionId}">${vitri.positionName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="education_degree_id">Vị trí</label>
                    <select class="form-control" id="education_degree_id" name="education_degree_id" required>
                        <c:forEach var="bangcap" items="${educationDegreeList}">
                            <c:choose>
                                <c:when test="${bangcap.educationDegreeId == 1}">
                                    <option value="${bangcap.educationDegreeId}">${bangcap.educationDegreeName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${bangcap.educationDegreeId}">${bangcap.educationDegreeName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="division_id">Vị trí</label>
                    <select class="form-control" id="division_id" name="division_id" required>
                        <c:forEach var="bophan" items="${divisionList}">
                            <c:choose>
                                <c:when test="${bophan.divisionId == 1}">
                                    <option value="${bophan.divisionId}">${bophan.divisionName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${bophan.divisionId}">${bophan.divisionName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="user_name">Tên Tài Khoản</label>
                    <input type="text" class="form-control" id="user_name" name="user_name" required>
                </div>
                <div class="form-group">
                    <label for="pass_work">Pass work</label>
                    <input type="text" class="form-control" id="pass_work" name="pass_work" required>
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
