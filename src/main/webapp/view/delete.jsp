<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/3/2024
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/glasses">Trở lại danh mục</a>
<h1>Bạn muốn xóa sản phẩm này</h1>
<div>
    <form method="post">
        <table>
            <tr>
                <td>ID</td>
                <td value=""><c:out value ='${dsk3.id}'/></td>
            </tr>
            <tr>
                <td>Code</td>
                <td value=""><c:out value ='${dsk3.code}'/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td value=""><c:out value ='${dsk3.price}'/></td>
            </tr>
            <tr>
                <td>Color</td>
                <td value=""><c:out value ='${dsk3.color}'/></td>
            </tr>
            <tr>
                <td>Decription</td>
                <td value=""><c:out value ='${dsk3.decription}'/></td>
            </tr>
        </table>
        <button>DELETE</button>
    </form>
</div>
</body>
</html>
