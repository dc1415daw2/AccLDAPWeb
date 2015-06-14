<%-- 
    Document   : login.jsp
    Created on : 10/04/2014, 09:38:30
    Author     : daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P&agrave;gina de validaci&oacute; d'usuaris autoritzats</title>
    </head>
    <body>
        <h1> L'ACCÉS A L'APLICACIÓ ESTÀ RESTRINGIT A USUARIS AUTORITZATS</h1>
        <h2> Si us plau, escriu el nom d'usuari i contrasenya d'un usuari autoritzat:</h2>
        <form action="j_security_check" method=post>
            <b>Nom d'usuari: </b><input type="text" name="j_username"></br>
            <b>Contrasenya:  </b><input type="password" name="j_password"></br></br>
            <input type="submit" value="Envia">
            <input type="reset" value="Esborra">            
        </form>
    </body>
</html>