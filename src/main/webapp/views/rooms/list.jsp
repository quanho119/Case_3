<%@ page import="org.example.hotelmanager.entity.Room" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
    List<Room> rooms= (List<Room>) request.getAttribute("rooms");
    int floor= (int) request.getAttribute("floor");
    int current = request.getParameter("floor") != null ? Integer.parseInt(request.getParameter("floor")) : 1;
    System.out.println(current);
%>
<html>
<head>
    <title>Hotel Manager</title>
</head>
<body>
<h1>Hotel rooms list</h1>
<br>
<button><a href="${pageContext.request.contextPath}/rooms/create">Create a new room</a></button>
<form action="${pageContext.request.contextPath}/rooms/search" method="get">
    <label for="search">Search</label>
    <br>
    <input type="text" name="keyword" id="search">
    <input type="submit" value="Search">
    <br>
    <a href="/rooms">Reset</a>
</form>
<button><a href="${pageContext.request.contextPath}/types">Room Types list</a></button>
<br>
<a href="${pageContext.request.contextPath}/rooms?floor=<%= current-1%>">Previous</a>
<c:forEach var="floorNow" begin="1" end="${floor}" >
    <button><a href="${pageContext.request.contextPath}/rooms?floor=${floorNow}">${floorNow}</a></button>
</c:forEach>
<a href="${pageContext.request.contextPath}/rooms?floor=<%= current+1%>">Next</a>
<table>
    <tr>
        <th>#</th>
        <th>Room number</th>
        <th>Floor</th>
        <th>Room type</th>
        <th>Price</th>
        <th>Status</th>
        <th>Action</th>
        <th>Update</th>
        <th>Remove</th>
    </tr>
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
                    <td><button><a href="${pageContext.request.contextPath}/rooms/checkin?id=${room.getId()}">Check in</a></button></td>
                </c:when>
                <c:otherwise>
                    <td><button><a href="${pageContext.request.contextPath}/rooms/checkout?id=${room.getId()}">Check out</a></button></td>
                </c:otherwise>
            </c:choose>
            <td><button><a href="${pageContext.request.contextPath}/rooms/update?id=${room.getId()}">Update</a></button></td>
            <td><button><a href="${pageContext.request.contextPath}/rooms/delete?id=${room.getId()}">Delete</a></button></td>
        </tr>
        <c:set var="index" value="${index+1}"/>
    </c:forEach>
</table
</body>
</html>
