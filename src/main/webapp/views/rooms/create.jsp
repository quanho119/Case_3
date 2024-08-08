<%@ page import="org.example.hotelmanager.entity.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.hotelmanager.entity.Status" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Type> types= (List<Type>) request.getAttribute("types");%>
<html>
<head>
    <title>Page Create Room</title>
</head>
<body>
<h2>Create Room</h2>
<br>
<form action="/rooms/create" method="post">
    <label for="room_number">Room number</label>
    <br>
    <input type="text" name="room_number" id="room_number">
    <br>
    <label for="floor_number">Floor</label>
    <br>
    <input type="number" name="floor_number" id="floor_number">
    <br>
    <label for="room_type_id">Type</label>
    <br>
    <select name="room_type_id" id="room_type_id">
        <c:forEach var="type" items="${types}">
         <option value="<c:out value="${type.id}"/>"><c:out value="${type.name}" /></option>
        </c:forEach>
    </select>
    <br>
    <label for="price">Price</label>
    <br>
    <input type="number" name="price" id="price">
    <br>
    <input type="submit" value="Create">
    <br>
    <button><a href="/rooms">Back to list</a></button>
</form>
</body>
</html>
