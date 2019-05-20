<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add userEntity</title>
</head>
<body>
<div align="center">
    <h2>Create userEntity</h2>
    <form:form action="save" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><form:input path="age"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
