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
    <jsp:useBean id="project" type="ru.trandefil.sc.model.Project" scope="request"/>
    <form method="post" action="projects">
        <input type="hidden" name="id" value="${project.id}">

        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${project.name}" size=40 name="name"></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${project.description}" name="description"></dd>
        </dl>
        <button type="submit">Save</button>
    </form>
</section>
</body>
</html>