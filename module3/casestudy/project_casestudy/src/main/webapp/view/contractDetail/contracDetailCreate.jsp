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
            <form action="/contractDetail?action=add" method="post">
                <div class="form-group">
                    <label for="contract_id">Mã Hợp Đồng</label>
                    <input type="text" class="form-control" id="contract_id" name="contract_id" required>
                </div>
                <div class="form-group">
                    <label for="attach_service_id">Mã dính kèm dịch vụ</label>
                    <input type="text" class="form-control" id="attach_service_id" name="attach_service_id" required>
                </div>
                <div class="form-group">
                    <label for="quantity">Số lượng</label>
                    <input type="text" class="form-control" id="quantity" name="quantity" required>
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
