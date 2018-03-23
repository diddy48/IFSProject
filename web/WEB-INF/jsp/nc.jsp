<%-- 
    Document   : nc
    Created on : 22-mar-2018, 21.37.45
    Author     : roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Esempio mapping</title>
 
    
</head>
 
 
<body>
    <h2>NC dipendente</h2>  
    
    <table border="1" cellspacing ="3">
	<tr>
            <th>Numero NC</th>
            <th>Titolo</th>
            <th>Descrizione</th>
            <th>Data Apertura</th>
            <th>Data Chiusura</th>
            <th>Priorità</th>
            <th>Codice Prodotto</th>
            
         </tr>
    <c:forEach items="${dipendente.ncLeader}" var="nc">
	<tr>
            <td>${nc.numeroNC}</td>
            <td>${nc.titolo}</td>
            <td>${nc.descrizione}</td>
            <td>${nc.dataA}</td>
            <td>${nc.dataC}</td>
            <td>${nc.priorita}</td>
            <td>${nc.codiceProdotto}</td>
         </tr>
    </c:forEach>
    </table>
    
</body>
</html>
