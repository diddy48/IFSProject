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
    <h2>Dipendenti</h2>  
    
   <c:if test="${!empty dipendenti}">
    <table border="1" cellspacing ="3">
        
	<tr>
            <th>Matricola</th>
            <th>Codice Fiscale</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Data di nascita</th>
            <th>Ruolo</th>
            <th>Mail</th>
            
         </tr>
    <c:forEach items="${dipendenti}" var="u">
	<tr>
            <td name ="matricola">${u.matricola}</td>
            <td>${u.cf}</td>
            <td>${u.nome}</td>
            <td>${u.cognome}</td>
            <td>${u.dataNascita}</td>
            <td>${u.ruolo}</td>
            <td>${u.mail}</td>
            <td><a href="<c:url value='/showNC/${u.matricola}' />" > NC Commissionate</a></td>
         </tr>
    </c:forEach>
    </table>
    
</c:if>
</body>
</html>