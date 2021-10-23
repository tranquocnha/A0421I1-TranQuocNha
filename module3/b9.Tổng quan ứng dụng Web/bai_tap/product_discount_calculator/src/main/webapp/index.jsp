<%--
  Created by IntelliJ IDEA.
  User: anhvi
  Date: 10/23/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="/discount" method="post">
    <label>Product Description: </label><br/>
    <input type="text" name="rate" placeholder="Product Description"/><br/>
    <label>List Price: </label><br/>
    <input type="text" name="price" placeholder="USD" /><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="percent" placeholder="%" /><br/>
    <input type = "submit" id = "submit" value = "Discount"/>
  </form>
  </body>
</html>
