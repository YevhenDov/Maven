<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h1>Users manager</h1>
    <h3><a href="/add">Add User</a></h3>
    <table border="1" padding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Create</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="userEntity" items="${userEntities}">
            <tr>
                <td>${userEntity.id}</td>
                <td>${userEntity.name}</td>
                <td>${userEntity.age}</td>
                <td>${userEntity.email}</td>
                <td>${userEntity.createdDate}</td>
                <td>
                    <a href="edit?id=${userEntity.id}">Edit</a>
                </td>
                <td>
                    <a href="delete?id=${userEntity.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
