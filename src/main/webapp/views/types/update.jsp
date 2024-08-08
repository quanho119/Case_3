<%@ page import="org.example.hotelmanager.entity.Type" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Type type = (Type) request.getAttribute("type"); %>
<html>
<head>
    <title>Page update type</title>
</head>
<body>
<h2>Update room type</h2>
<form action="/types/update" method="post">
    <label for="name">Name</label>
    <br>
    <input type="hidden" name="id" id="id" value="${type.id}">
    <input type="text" name="name" id="name" value="${type.name}"><br/>
    <input type="submit" value="Update">
    <br>
    <a href="types">Back to list</a>
</form>
</body>
</html>
