<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome to the chat</title>
</head>
<h3>Вы вошли как пользователь - ${pageContext.request.userPrincipal.name} </h3>
<h4><a href="/logout">Выйти</a></h4>
<br>
<body>

<table class="table">
    <tr>
        <th>Пользователь:</th>
        <th>Сообщение:</th>
        <th>ДатаВремя</th>
    </tr>

    <c:forEach var="allMessage" items="${allMessage}">
        <tr>
            <td>${allMessage.userName}</td>
            <td>${allMessage.message}</td>
            <td>${allMessage.dateTime}</td>
        </tr>
    </c:forEach>
</table>

<br>
<br>

<table class="table">


    <%--@elvariable id="newMessage" type="java"--%>
    <form:form action="addMessage" modelAttribute="newMessage">
        Новое сообщение: <form:input path="message"/>
            <form:errors path="message"></form:errors>
        <input type="submit" value="Отправить">
    </form:form>

    <table >
</body>
</html>