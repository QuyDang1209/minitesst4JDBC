<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/2/2024
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Glasses</title>
    <style>
        .image-frame{
            width: 200px;
            height: 200px;
            overflow: hidden;
        }
    </style>
</head>
<body>
<h1>DANH MỤC KÍNH</h1>
<div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>CODE</th>
            <th>PRICE</th>
            <th>COLOR</th>
            <th>DECRIPTION</th>
            <th>INMAGE</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${list}" var="li">
            <tr>
            <td>${li.id}</td>
            <td>${li.code}</td>
            <td>${li.price}</td>
            <td>${li.color}</td>
            <td>${li.decription}</td>
            <td><img src="${li.img}" class="image-frame"></td>
                <td>
                    <a href="/glasses?action=edit&id=${li.id}">Edit</a>
                    <a href="/glasses?action=delete&id=${li.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <a href="/glasses?action=create">Thêm mới</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
