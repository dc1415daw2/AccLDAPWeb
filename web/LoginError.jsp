<%-- 
    Document   : ErrLogin.jsp
    Created on : 10/04/2014, 09:39:00
    Author     : daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticaci&oacute; incorrecta</title>
    </head>
    <body>
        <c:url var="url" value="/Login.jsp"/>
        <h1>Autenticaci&oacute; incorrecta</h1> 
        <b><a href="${url}">Intenta-ho una altra vegada</a></b>
    </body>
</html>
