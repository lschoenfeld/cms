<%--
  Created by IntelliJ IDEA.
  User: larryschoenfeld
  Date: 3/28/14
  Time: 9:22 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
${flash.message}


<g:form action="save">
    Author:<g:textField value="${params.author}"  name="author"/>
    Document Key:<g:textField name="documentKey"  value="${params.documentKey}"/>
    Entry: <g:textArea name="entry" value="${params.entry}"/>
    <g:submitButton name="submit" value="Save"/>
</g:form>


</body>
</html>