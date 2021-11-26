<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/22/2021
  Time: 6:08 PM
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
<form action="/product" method="get">
    <input name="action" type="hidden" value="find">
    <label>Find employee by Name<input name="product_name" type="text"></label>
    <label>Find employee by Color<input name="product_color" type="text"></label>
    <label>Find employee by Address<input name="product_address" type="text"></label>
    <input type="submit" value="Name Customer">
</form>
<a href="/product?action=add">Thêm San Pham</a>
<div class="container">
    <c:if test="${mess!=null}">
        <strong style="color: red">${mess}</strong>
    </c:if>
    <table id="page" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Color</th>
            <th scope="col">Category</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="loop" var="sanpham" items="${productList}">
            <tr>
                <td>${loop.count}</td>
                <td>${sanpham.productName}</td>
                <td>${sanpham.productPrice}</td>
                <td>${sanpham.productQuantity}</td>
                <td>${sanpham.productColor}</td>
                <td>
                    <c:if test="${sanpham.categoryId==0}">
                        <span>null</span>
                    </c:if>
                    <c:forEach items="${categoryList}" var="danhmuc">
                        <c:if test="${danhmuc.categoryId==sanpham.categoryId}">
                            <span>${danhmuc.categoryName}</span>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <button type="button" class="btn btn-info">
                        <a href="/product?action=update&id=${sanpham.productId}" class="text-white">Sửa</a>
                    </button>
                    <button type="button" class="btn btn-danger" onclick="setValueForm('${sanpham.productId}')"
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
                <form method="post" action="/product?action=delete">
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
