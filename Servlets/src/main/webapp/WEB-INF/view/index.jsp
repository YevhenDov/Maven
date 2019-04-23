<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD</title>
</head>
<body>
<h1>All developers</h1><br/>
<c:forEach var="developer" items="${requestScope.developers}">
    <ul>
        <li>ID: <c:out value="${developer.id}"/></li>
        <li>Name: <c:out value="${developer.name}"/></li>
        <li>Age: <c:out value="${developer.age}"/></li>
        <li>Salary: <c:out value="${developer.salary}"/></li>

        <form method="post" action="/remove">
            <input type="number" hidden name="id" value="${developer.id}"/>
            <input type="submit" name="remove" value="Remove"/>
        </form>

        <form method="get" action="/update">
            <input type="number" hidden name="id" value="${developer.id}"/>
            <input type="submit" name="update" value="Update"/>
        </form>
    </ul>
    <hr />
</c:forEach>

<h2>Adding new developer</h2>
<form method="post" action="">
    <label><input type="text" name="name"></label>Name<br>
    <label><input type="number" name="age"></label>Age<br>
    <label><input type="number" name="salary"></label>Salary<br>
    <input type="submit" value="OK" name="OK"><br>
</form>
</body>
</html>
