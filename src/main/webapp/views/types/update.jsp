<%@ page import="org.example.hotelmanager.entity.Type" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Type type = (Type) request.getAttribute("type"); %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Room Type</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <a href="${pageContext.request.contextPath}/rooms" class="text-decoration-none">
        <h1 class="mb-4 text-primary">Hotel Rooms List</h1>
    </a>
    <h2>Update Room Type</h2>
    <form action="/types/update" method="post">
        <input type="hidden" name="id" id="id" value="${type.id}">

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" class="form-control" value="${type.name}" required>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
        <a href="${pageContext.request.contextPath}/types" class="btn btn-secondary">Back to List</a>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
