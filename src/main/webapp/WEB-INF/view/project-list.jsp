<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Добро пожаловать, JSP!</title>
  </head>
  <body>
       <h1>Добро пожаловать!</h1>
           <table class="item-table"  width="59%" border="1" align="left">
               <tr>
                   <th>id</th>
                   <th>name</th>
               </tr>
                <c:forEach items="${items}" var="item">
                    <tr align="center" style="color:blue">
                         <td>${item.id}</td>
                         <td>${item.name}</td>
                     </tr>
                </c:forEach>
  </body>
</html>
