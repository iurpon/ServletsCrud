<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Добро пожаловать, JSP!</title>
  </head>
  <h2><a href="addProject">Add New Project</a></h2>
  <body>
       <h1>Добро пожаловать!</h1>
           <table class="item-table"  width="59%" border="1" align="left">
               <tr>
                   <th></th>
                   <th>Name</th>
                   <th>Description</th>
                   <th>Action</th>
                   <th>Action</th>
               </tr>
                <c:forEach items="${items}" var="item" varStatus="status">
                    <tr align="center" style="color:blue">
                        <td>${status.index + 1}</td>
                         <td>${item.name}</td>
                         <td>${item.description}</td>
                        <td><a href="updateProject?id=${item.id}">Update</a></td>
                        <td><a href="deleteProject?id=${item.id}">Delete</a></td>
                     </tr>
                </c:forEach>
  </body>
</html>
