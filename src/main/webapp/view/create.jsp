<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/3/2024
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/glasses">Trở lại danh mục</a> <br>
<span>${mess1}</span>
<div>
    <form method="post">
        <input type="text" name="ID" placeholder="Nhập ID">
        <input type="text" name="CODE" placeholder="Nhập CODE">
        <input type="text" name="PRICE" placeholder="Nhập PRICE">
        <input type="text" name="COLOR" placeholder="Nhập COLOR">
        <input type="text" name="DECRIPTION" placeholder="Nhập DECRIPTION">
        <input type="text" name="IMG" placeholder="Nhập ẢNH">
        <button>SAVE</button>
    </form>
</div>
</body>
</html>
