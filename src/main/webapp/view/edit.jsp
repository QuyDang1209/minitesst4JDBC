<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/3/2024
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/glasses">Trở lại danh mục</a> <br>
<span>${mess2}</span>
<div>
    <form method="post">
        <table>
            <tr>ID</tr>
            <tr>
                <c:if test="${dsk2 != null}">
                    <input type="hidden" name="ID" value="<c:out value ='${dsk2.id}'/>">
                </c:if>
            </tr>
            <tr>
                <td>CODE</td>
                <td>
                    <input type="text" name="CODE" value="<c:out value ='${dsk2.code}'/>">
                </td>
            </tr>
            <tr>
                <td>PRICE</td>
                <td>
                    <input type="text" name="PRICE" value="<c:out value ='${dsk2.price}'/>">
                </td>
            </tr>
            <tr>
                <td>COLOR</td>
                <td>
                    <input type="text" name="COLOR" value="<c:out value ='${dsk2.color}'/>">
                </td>
            </tr>
            <tr>
                <td>DECRIPTION</td>
                <td>
                    <input type="text" name="DECRIPTION" value="<c:out value ='${dsk2.decription}'/>">
                </td>
            </tr>
            <tr>
                <td>INMAGE</td>
                <td>
                    <input type="text" name="IMG" value="<c:out value ='${dsk2.img}'/>">
                </td>
            </tr>
        </table>
       <button>SAVE</button>
    </form>
</div>
</body>
</html>