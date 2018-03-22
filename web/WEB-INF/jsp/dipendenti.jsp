<%-- 
    Document   : impiegatiList
    Created on : 3-dic-2017, 17.38.24
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Esempio mapping</title>
 
    
</head>
 
 
<body>
    <h2>Utenti</h2>  
    <table border="1" cellspacing ="3">
    <c:forEach items="${dipendenti}" var="u">
	<tr>
            <td>${u.nome}</td>
            <td>${u.cognome}</td>
         </tr>
    </c:forEach>
    </table>
</body>
</html>