<%@ page import="org.example.hotelmanager.entity.Room" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
    List<Room> rooms = (List<Room>) request.getAttribute("rooms");
    Integer floor = (Integer) request.getAttribute("floor");
    Integer current = request.getParameter("floor") != null ? Integer.parseInt(request.getParameter("floor")) : 1;
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Manager</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <a href="${pageContext.request.contextPath}/rooms" class="text-decoration-none">
        <h1 class="mb-4 text-primary">Hotel Rooms List</h1>
    </a>
    <div class="mb-3">
        <a href="${pageContext.request.contextPath}/rooms/create" class="btn btn-primary">Create a new room</a>
        <a href="${pageContext.request.contextPath}/types" class="btn btn-info">Room Types List</a>
    </div>

    <form action="${pageContext.request.contextPath}/rooms/search" method="get" class="form-inline mb-3">
        <div class="form-group mr-2">
            <label for="search" class="sr-only">Search</label>
            <input type="text" name="keyword" id="search" class="form-control" placeholder="Search...">
        </div>
        <button type="submit" class="btn btn-secondary">Search</button>
        <a href="${pageContext.request.contextPath}/rooms" class="btn btn-link">Reset</a>
    </form>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item <%= current == 1 ? "disabled" : "" %>">
                <a class="page-link" href="${pageContext.request.contextPath}/rooms?floor=<%= current - 1 %>">Previous</a>
            </li>
            <c:forEach var="floorNow" begin="1" end="${floor}">
                <li class="page-item ${current == floorNow ? 'active' : ''}">
                    <a class="page-link" href="${pageContext.request.contextPath}/rooms?floor=${floorNow}">${floorNow}</a>
                </li>
            </c:forEach>
            <li class="page-item <%= current.equals(floor) ? "disabled" : "" %>">
                <a class="page-link" href="${pageContext.request.contextPath}/rooms?floor=<%= current + 1 %>">Next</a>
            </li>
        </ul>
    </nav>

    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>#</th>
            <th>Room Number</th>
            <th>Floor</th>
            <th>Room Type</th>
            <th>Price</th>
            <th>Status</th>
            <th>Action</th>
            <th>Update</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="index" value="1"/>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td><c:out value="${index}" /></td>
                <td><c:out value="${room.room_number}" /></td>
                <td><c:out value="${room.floor_number}" /></td>
                <td><c:out value="${room.room_type}" /></td>
                <td><c:out value="${room.price}" /></td>
                <td><c:out value="${room.room_status}" /></td>
                <c:choose>
                    <c:when test="${room.room_status eq 'Available'}">
                        <td><a href="${pageContext.request.contextPath}/rooms/checkin?id=${room.getId()}" class="btn btn-success">Check in</a></td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="${pageContext.request.contextPath}/rooms/checkout?id=${room.getId()}" class="btn btn-danger">Check out</a></td>
                    </c:otherwise>
                </c:choose>
                <td><a href="${pageContext.request.contextPath}/rooms/update?id=${room.getId()}" class="btn btn-warning">Update</a></td>
                <td><a href="${pageContext.request.contextPath}/rooms/delete?id=${room.getId()}" class="btn btn-danger">Delete</a></td>
            </tr>
            <c:set var="index" value="${index + 1}"/>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
