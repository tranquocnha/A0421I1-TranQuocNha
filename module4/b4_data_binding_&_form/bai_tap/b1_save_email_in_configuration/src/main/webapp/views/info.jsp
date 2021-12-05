<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 11/29/2021
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h2>Submitted Email Information</h2>
<table>
    <tr>
        <td>Language:</td>
        <td>${email.language}</td>
    </tr>
    <tr>
        <td>Page sizze:</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spams Filter:</td>
        <td>${email.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>
