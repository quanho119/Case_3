<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page create type</title>
</head>
<body>
<h2>Create room type</h2>
<form action="/types/create" method="post">
    <label for="name">Name</label>
    <br>
    <input type="text" name="name" id="name"><br/>
    <input type="submit" value="Create">
    <br>
    <a href="types">Back to list</a>
</form>
</body>
</html>
