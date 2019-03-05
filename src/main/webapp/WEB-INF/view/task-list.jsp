<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
    <link rel="stylesheet" type="text/css" href="resources/css/blueTable.css">
</head>
<p>
<ul class="menu">
    <li><a class="menu" href="projects">See all Project</a></li>
    <li><a class="menu" href="index.html">Home</a></li>
</ul>
</p>
<body>
<table class="blueTable">
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
 </table>
</body>
</html>
