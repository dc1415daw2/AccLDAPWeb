<%-- 
    Document   : index.jsp
    Created on : 24/04/2014, 20:41:57
    Author     : daw2
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>APLICACIÓ RESTRINGIDA A USUARIS AUTORITZATS: ACCÉS A OPENLDAP</h1>
        <h2> Si us plau, escriu el nom d'usuari i la seva unitat organitzativa:</h2>
        <form action="ServConsLDAP" method=post>
            <b>Nom d'usuari: </b><input type="text" name="uid"></br>
            <b>Unitat organitzativa:  </b><input type="text" name="uo"></br></br>
            <input type="submit" value="Envia">
            <input type="reset" value="Esborra">            
        </form>
    </body>
</html>