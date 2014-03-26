<%--
  Created by IntelliJ IDEA.
  User: Larry
  Date: 3/24/14
  Time: 5:45 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
Name:${document.documentKey}
<BR>
Author: ${document.author}
<BR>
<BR>

${document.entry}

<BR>
<g:link action="index">Return to list</g:link>

</body>
</html>