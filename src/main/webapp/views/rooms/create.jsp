<%@ page import="org.example.hotelmanager.entity.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.hotelmanager.entity.Status" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Type> types = (List<Type>) request.getAttribute("types"); %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Room</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Create Room</h2>
    <form action="/rooms/create" method="post">
        <div class="form-group">
            <label for="room_number">Room Number</label>
            <input type="text" name="room_number" id="room_number" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="floor_number">Floor</label>
            <input type="number" name="floor_number" id="floor_number" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="room_type_id">Type</label>
            <select name="room_type_id" id="room_type_id" class="form-control" required>
                <c:forEach var="type" items="${types}">
                    <option value="${type.id}">${type.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" name="price" id="price" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <a href="/rooms" class="btn btn-secondary">Back to list</a>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
