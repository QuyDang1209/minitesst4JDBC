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
        <table>
            <tr>
                <td>ID</td>
                <td>
                    <input type="text" name="ID" placeholder="Nhập ID">
                </td>
            </tr>
            <tr>
                <td>CODE</td>
                <td>
                    <input type="text" name="CODE" placeholder="Nhập mã">
                </td>
            </tr>
            <tr>
                <td>PRICE</td>
                <td>
                    <input type="text" name="PRICE" placeholder="Nhập giá">
                </td>
            </tr>
            <tr>
                <td>COLOR</td>
                <td>
                    <input type="text" name="COLOR" placeholder="Nhập màu kính">
                </td>
            </tr>
            <tr>
                <td>DECRIPTION</td>
                <td>
                    <input type="text" name="DECRIPTION" placeholder="Nhập Mô Tả">
                </td>
            </tr>
            <tr>
                <td>INMAGE</td>
                <td>
                    <input type="text" name="IMG" placeholder="Nhập ẢNH">
                </td>
            </tr>
        </table>
        <button>SAVE</button>
    </form>
</div>
</body>
</html>
