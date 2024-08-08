<%@ page import="org.example.hotelmanager.entity.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.hotelmanager.entity.Status" %>
<%@ page import="org.example.hotelmanager.entity.Room" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Room room = (Room) request.getAttribute("room"); %>
<% List<Type> types = (List<Type>) request.getAttribute("types"); %>
<% List<Status> statuses = (List<Status>) request.getAttribute("statuses"); %>
<html>
<head>
    <title>Page update room</title>
</head>
<body>
<h2>Update Room</h2>
<form action="/rooms/update" method="post">
    <input type="hidden" name="id" id="id" value="${room.id}">
    <label for="room_number">Room number</label>
    <br>
    <input type="text" name="room_number" id="room_number" value="${room.room_number}">
    <br>
    <label for="floor_number">Floor</label>
    <br>
    <input type="number" name="floor_number" id="floor_number" value="${room.floor_number}">
    <br>
    <label for="room_type_id">Type</label>
    <br>
    <select name="room_type_id" id="room_type_id">
        <c:forEach var="type" items="${types}">
            <option value="${type.id}" ${room.room_type_id == type.id ? 'selected' : ''}>${type.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="room_status_id">Status</label>
    <br>
    <select name="room_status_id" id="room_status_id">
        <c:forEach var="status" items="${statuses}">
            <option value="${status.id}" ${room.room_status_id == status.id ? 'selected' : ''}>${status.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="price">Price</label>
    <br>
    <input type="number" name="price" id="price" value="${room.price}">
    <br>
    <input type="submit" value="Submit">
    <br>
    <a href="/rooms">Back to list</a>
</form>
</body>
</html>
