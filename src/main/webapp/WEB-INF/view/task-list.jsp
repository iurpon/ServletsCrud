<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
</head>
<h2><a href="projects">Projects</a></h2>
<h2><a href="index.html">Home</a></h2>
<h2><a href="tasks">Tasks</a></h2>
<body>
<h1>Добро пожаловать!</h1>
<table class="item-table"  width="59%" border="1" align="left">
    <tr>
        <th></th>
        <th>Name</th>
        <th>Description</th>
        <th>Project</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${tasks}" var="task" varStatus="status">
    <tr align="center" style="color:blue">
        <td>${status.index + 1}</td>
        <td>${task.name}</td>
        <td>${task.description}</td>
        <td>${task.project.name}</td>
        <td><a href="updateTask?id=${task.id}">Update</a></td>
        <td><a href="deleteTask?id=${task.id}">Delete</a></td>
    </tr>
    </c:forEach>
</body>
</html>
