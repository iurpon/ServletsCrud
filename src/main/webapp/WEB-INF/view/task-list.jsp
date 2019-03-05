<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style >
                <%@include file="/WEB-INF/css/blueTable.css"%>
            </style>
</head>
<li><a href="projects">See All Projects</a></li>
<li><a href="index.html">Home</a></li>
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
</body>
</html>
