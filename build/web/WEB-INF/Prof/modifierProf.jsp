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
       <h1>modification</h1>
        
        <form method="POST" action="">
            <label>CODE PROF</label>
            <input name="codeprof" placeholder="code prof" value="${ prof.getCodeprof() }" /> <br/>
            <label>NOM</label>
            <input name="nom" placeholder="nom" value="${ prof.getNom() }" /> <br/>
            <label>PRENOM</label>
            <input name="prenom" placeholder="prenom" value="${ prof.getPrenom() }" /> <br/>
            <label>GRADE</label>
            <input name="grade" placeholder="grade" value="${ prof.getGrade() }" />

            <button type="submit" >envoyer</button>
        </form>
    </body>
</html>
