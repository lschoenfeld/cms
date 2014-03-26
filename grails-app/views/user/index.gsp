<%--
  Created by IntelliJ IDEA.
  User: Larry
  Date: 3/24/14
  Time: 5:09 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <style>
    td, th {
        border: 1px solid black;
    }
    </style>
</head>

<body>
<table>
    <tr>
        <th>Name</th>
        <th>Author</th>
        <th>End Date</th>
    </tr>
    <g:each in="${contents}" var="content">
        <tr>
            <td><g:link action="show" id="${content.id}">${content.documentKey}</g:link></td>
            <td>${content.author}</td>
            <td><dt:formatDate date="${content.endDate}"/></td>
        </tr>

    </g:each>
</table>
</body>
</html>