<%-- 
    Document   : ajouterOccupe
    Created on : 23 févr. 2024, 12:38:31
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
        <h1>ajouter</h1>
        
        <form method="POST" action="">
            <label>CODE PROF</label>
            <select name="idprof">
                <c:forEach items="${ profs }" var="p">
                    <option value="${ p.getId() }"> ${ p.getCodeprof() } </option>
                </c:forEach>
            </select> <br />
            <label>CODE SALLE</label>
            <select name="idsal">
                <c:forEach items="${ salles }" var="s">
                    <option value="${ s.getId() }"> ${ s.getCodesal() } </option>
                </c:forEach>
            </select> <br />
            <label>Date</label>
            <input name="date" type="date" />
            
            <button type="submit" > ajouter </button>
        </form>
    </body>
</html>
