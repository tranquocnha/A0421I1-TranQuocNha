<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/13/2021
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <form action="/contract?action=add" method="post">

                <div class="form-group">
                    <label for="contract_start_date">Ngày Bắt Đầu Hợp Đồng</label>
                    <input type="date" class="form-control" id="contract_start_date" name="contract_start_date" required>
                </div>
                <div class="form-group">
                    <label for="contract_end_date">Ngày Kết Thúc Hợp Đồng</label>
                    <input type="date" class="form-control" id="contract_end_date" name="contract_end_date" required>
                </div>
                <div class="form-group">
                    <label for="contract_deposit">Tiền quỹ hợp đồng</label>
                    <input type="text" class="form-control" id="contract_deposit" name="contract_deposit" required>
                </div>
                <div class="form-group">
                    <label for="contract_total_money">Hợp Đồng Tổng Số Tiền</label>
                    <input type="text" class="form-control" id="contract_total_money" name="contract_total_money" required>
                </div>
                <div class="form-group">
                    <label for="employee_id">Nhân viên Kí Hợp Đồng</label>
                    <input type="text" class="form-control" id="employee_id" name="employee_id" required>
                </div>
                <div class="form-group">
                    <label for="customer_id">Khách Hàng Kí Hợp Đồng</label>
                    <input type="text" class="form-control" id="customer_id" name="customer_id" required>
                </div>
                <div class="form-group">
                    <label for="service_id">Dịch vu Hợp Đồng</label>
                    <input type="text" class="form-control" id="service_id" name="service_id" required>
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
