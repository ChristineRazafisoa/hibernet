<%-- 
    Document   : modifierSalle
    Created on : 23 févr. 2024, 12:37:01
    Author     : Bota
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form method="POST" action="">
            <label>CODE SALLE</label> <input name="codesal" value="<c:out value="${ salle.getCodesal() }" />" /> <br/>
            <label>CODE SALLE</label> <input name="designation" value="<c:out value="${ salle.getDesignation() }" />" /> <br/>
            <button type="submit">modifier</button>
        </form>
    </body>
</html>
