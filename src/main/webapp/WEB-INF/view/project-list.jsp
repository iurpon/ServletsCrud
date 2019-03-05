<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style >
            <%@include file="/WEB-INF/css/blueTable.css"%>
        </style>

  </head>
<li><a href="addProject">Add New Project</a></li>
<li><a href="tasks">See all Tasks</a></li>
<li><a href="index.html">Home</a></li>
  <body>
           <table class = "blueTable">
               <tr>
                   <th></th>
                   <th>Name</th>
                   <th>Description</th>
                   <th>Action</th>
                   <th>Action</th>
                   <th>Action</th>
               </tr>
                <c:forEach items="${items}" var="project" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                         <td>${project.name}</td>
                         <td>${project.description}</td>
                        <td><a href="updateProject?id=${project.id}">Update</a></td>
                        <td><a href="deleteProject?id=${project.id}">Delete</a></td>
                        <td><a href="addTask?id=${project.id}">Add Task</a></td>
                     </tr>
                </c:forEach>
  </body>
</html>
