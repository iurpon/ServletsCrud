<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Project</title>
    <style>
        dl {
            background: none repeat scroll 0 0 #FAFAFA;
            margin: 8px 0;
            padding: 0;
        }

        dt {
            display: inline-block;
            width: 170px;
        }

        dd {
            display: inline-block;
            margin-left: 8px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <jsp:useBean id="task" type="ru.trandefil.sc.model.Task" scope="request"/>
    <form method="post" action="updateTask">
        <input type="hidden" name="id" value="${task.id}">

        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${task.name}" name="name"></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${task.description}" size=40 name="description"></dd>
        </dl>
        <dl>
            <dt>Project:</dt>
            <dd><input type="text" value="${task.project.name}"  name="projectName" readonly></dd>
        </dl>
        <button type="submit">Save</button>
    </form>
</section>
</body>
</html>