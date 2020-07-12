<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>USERS</title>
</head>
<body>

<h1>Users JAVA-MENTOR </h1>
<table>
    <tr>
        <th>id</th>
        <th>Имя</th>
        <th>Фамиия</th>
        <th>Мыло</th>
        <th>Возраст</th>
        <th>Деяния</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td>
                <a href="/edit/${user.id}">ред.</a>
                <a href="/delete/${user.id}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Добавить нового пользователя</h2>
<c:url value="/add" var="add"/>
<a href="${add}">добавить нового юзира</a>
</body>
</html>