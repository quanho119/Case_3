<%@ page import="org.example.hotelmanager.entity.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.hotelmanager.entity.Status" %>
<%@ page import="org.example.hotelmanager.entity.Room" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Room room = (Room) request.getAttribute("room"); %>
<% List<Type> types = (List<Type>) request.getAttribute("types"); %>
<% List<Status> statuses = (List<Status>) request.getAttribute("statuses"); %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Room</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <a href="${pageContext.request.contextPath}/rooms" class="text-decoration-none">
        <h1 class="mb-4 text-primary">Hotel Rooms List</h1>
    </a>
    <h2>Update Room</h2>
    <form action="/rooms/update" method="post">
        <input type="hidden" name="id" id="id" value="${room.id}">

        <div class="form-group">
            <label for="room_number">Room Number</label>
            <input type="text" name="room_number" id="room_number" class="form-control" value="${room.room_number}" required>
        </div>

        <div class="form-group">
            <label for="floor_number">Floor</label>
            <input type="number" name="floor_number" id="floor_number" class="form-control" value="${room.floor_number}" required>
        </div>

        <div class="form-group">
            <label for="room_type_id">Type</label>
            <select name="room_type_id" id="room_type_id" class="form-control" required>
                <c:forEach var="type" items="${types}">
                    <option value="${type.id}" ${room.room_type_id == type.id ? 'selected' : ''}>${type.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="room_status_id">Status</label>
            <select name="room_status_id" id="room_status_id" class="form-control" required>
                <c:forEach var="status" items="${statuses}">
                    <option value="${status.id}" ${room.room_status_id == status.id ? 'selected' : ''}>${status.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" name="price" id="price" class="form-control" value="${room.price}" required>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
        <a href="/rooms" class="btn btn-secondary">Back to list</a>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
