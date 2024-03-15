<%-- 
    Document   : ajouterProf
    Created on : 23 févr. 2024, 12:34:19
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
       <h1>Ajout</h1>
        
        <form method="POST" action="">
            <input name="codeprof" placeholder="code prof" />
            <input name="nom" placeholder="nom" />
            <input name="prenom" placeholder="prenom" />
            <input name="grade" placeholder="grade" />

            <button type="submit" >envoyer</button>
        </form>
    </body>
</html>
