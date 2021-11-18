<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/11/2021
  Time: 5:13 PM
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
<form action="/customer" method="get">
  <input name="action" type="hidden" value="find">
  <label id="find">Find User by Name<input name="customer_name" type="text"></label>
  <input type="submit" value="Name Customer">
</form>
<a href="/contract?action=add">Thêm hợp đồng</a>
<a href="customer?action=add"> Thêm khách hàng</a>
<div class="container">
  <c:if test="${mess!=null}">
    <strong style="color: red">${mess}</strong>
  </c:if>
  <table id="page" class="table table-striped">
    <thead>
      <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã khách hàng</th>
        <th scope="col">Loại khách hàng</th>
        <th scope="col">Tên khách hàng</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Số chứng minh</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Email</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Tác Vụ</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="loop" var="khachhang" items="${customerList}">
      <tr>
        <td>${loop.count}</td>
        <td>${khachhang.customerCode}</td>
        <td>
          <c:if test="${khachhang.customerTypeId==0}">
            <span>null</span>
          </c:if>
          <c:forEach items="${customerTypeList}" var="loaikhachhang">
            <c:if test="${khachhang.customerTypeId==loaikhachhang.customerTypeId}">
              <span>${loaikhachhang.customerTypeName}</span>
            </c:if>
          </c:forEach>
        </td>
        <td>${khachhang.customerName}</td>
        <td>${khachhang.customerBirthday}</td>
        <td>${khachhang.customerGender}</td>
        <td>${khachhang.customerIdCard}</td>
        <td>${khachhang.customerPhone}</td>
        <td>${khachhang.customerEmail}</td>
        <td>${khachhang.customerAddress}</td>
        <td>
          <button type="button" class="btn btn-info">
            <a href="/customer?action=update&id=${khachhang.customerId}" class="text-white">Sửa</a>
          </button>
          <button type="button" class="btn btn-danger" onclick="setValueForm('${khachhang.customerId}')"
                  data-toggle="modal" data-target="#modalDelete">
            Xoá
          </button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <!-- Modal confirm delete -->
  <div class="modal fade" id="modalDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <form method="post" action="/customer?action=delete">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <input name="idDelete" id="idDelete" hidden>
            Bạn có chắc muốn xoá ?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            <button type="submit" class="btn btn-danger">Xoá</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

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
<script>
  function setValueForm(idDelete) {
    document.getElementById("idDelete").value = idDelete;
  }
</script>
</body>
</html>
