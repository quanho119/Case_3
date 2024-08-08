<%@ page import="org.example.hotelmanager.entity.Type" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Type> types = (List<Type>) request.getAttribute("types"); %>
<html>
<head>
    <title>Types List</title>
</head>
<body>
<h1>Types List</h1>
<br>
<button><a href="${pageContext.request.contextPath}/types/create">Create a new type</a></button>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach var="type" items="${types}">
        <tr>
            <td>${type.id}</td>
            <td>${type.name}</td>
            <td><a href="${pageContext.request.contextPath}/types/update?id=${type.id}">Update</a></td>
            <td><a href="${pageContext.request.contextPath}/types/delete?id=${type.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<button><a href="/rooms/">Back rooms list</a></button>
</body>
</html>
