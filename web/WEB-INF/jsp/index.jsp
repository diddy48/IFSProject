<%-- 
    Document   : login
    Created on : 5-apr-2018, 21.44.49
    Author     : roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>Inserisci la mail: </td>
                    <td><input name="mail" type="text" placeholder="Mail" required></td>
                </tr
                <tr>
                    <td>Inserisci la password: </td>
                    <td><input name="password" type="text" placeholder="Password" required></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="Accedi"></td>
                </tr>
            </table>
        </form>
       <c:if test="${error!=null}">
           <h4 style="color:red;">${error}</h4>
       </c:if>
    </body>
</html>
