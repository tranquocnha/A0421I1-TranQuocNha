<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/29/2021
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Stacked form</h2>
  <form action="/addition">
    <div class="form-group">
      <label for="number">First Number:</label>
      <input type="number" class="form-control" id="number" placeholder="Enter number" name="firstNum" value="0>${firstNum}">
      <c:if test="${message1!=null}">
        <small class="text-danger">${message1}</small>
      </c:if>
    </div>
    <div class="form-group">
      <label for="number2">Last Number:</label>
      <input type="number" class="form-control" id="number2" placeholder="Enter number" name="lastNum" value="0>${lastNum}">
      <c:if test="${message2!=null}">
        <small class="text-danger">${message2}</small>
      </c:if>
    </div>
    <button type="submit" class="btn btn-primary" name="calculation" value="add">+</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="sub">-</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="mul">X</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="div">/</button>
  </form>

  <h4>Result Division: ${result}</h4>
</div>

</body>
</html>