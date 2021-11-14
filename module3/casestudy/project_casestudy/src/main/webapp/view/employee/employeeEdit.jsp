<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/13/2021
  Time: 1:45 PM
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
            <form action="/employee?action=update" method="post">
                <input hidden="hidden" name ="employee_id" value="${employeeList.employeeId}">
                <div class="form-group">
                    <label for="employee_name">Tên Nhân viên</label>
                    <input type="text" class="form-control" id="employee_name" name="employee_name" value="${employeeList.employeeName}"  required>
                </div>

                <div class="form-group">
                    <label for="employee_birthday">Ngày Sinh</label>
                    <input type="date" class="form-control" id="employee_birthday" name="employee_birthday" value="${employeeList.employeeBirthday}" required>
                </div>
                <div class="form-group">
                    <label for="employee_id_card">Số chứng minh</label>
                    <input type="text" class="form-control" id="employee_id_card" name="employee_id_card" value="${employeeList.employeeIdCard}" required>
                </div>
                <div class="form-group">
                    <label for="employee_salary">Lương nhân viên</label>
                    <input type="text" class="form-control" id="employee_salary" name="employee_salary" value="${employeeList.employeeSalary}" required>
                </div>
                <div class="form-group">
                    <label for="employee_phone">Số điện thoại</label>
                    <input type="text" class="form-control" id="employee_phone" name="employee_phone" value="${employeeList.employeePhone}" required>
                </div>
                <div class="form-group">
                    <label for="employee_email">Email</label>
                    <input type="text" class="form-control" id="employee_email" name="employee_email" value="${employeeList.employeeEmail}" required>
                </div>
                <div class="form-group">
                    <label for="employee_address">Địa chỉ</label>
                    <input type="text" class="form-control" id="employee_address" name="employee_address" value="${employeeList.employeeAddress}" required>
                </div>
                <div class="form-group">
                    <label for="position_id">Vị trí</label>
                    <select class="form-control" id="position_id" name="position_id" required>
                        <c:forEach var="vitri" items="${positionList}">
                            <c:choose>
                                <c:when test="${vitri.positionId == employeeList.positionId}">
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
                    <label for="education_degree_id">Bằng cấp</label>
                    <select class="form-control" id="education_degree_id" name="education_degree_id" required>
                        <c:forEach var="bangcap" items="${educationDegreeList}">
                            <c:choose>
                                <c:when test="${bangcap.educationDegreeId == employeeList.educationDegreeId}">
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
                    <label for="division_id">Bộ phận</label>
                    <select class="form-control" id="division_id" name="division_id" required>
                        <c:forEach var="bophan" items="${divisionList}">
                            <c:choose>
                                <c:when test="${bophan.divisionId == employeeList.divisionId}">
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
                    <input type="text" class="form-control" id="user_name" name="user_name" value="${employeeList.userName}" required readonly>
                </div>
                <button type="submit" class="btn btn-primary">Lưu</button>
                <button type="button" class="btn btn-success">
                    <a href="/employee" class="text-white">Quay Lại</a>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
