<%-- 
    Document   : test
    Created on : 27-mar-2014, 14:45:04
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" type="text/css" href="css/plantilla0.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div id="cabecera1">
            <h1>Muro de abc</h1>
        </div>
        <div id="ladoiz"> 
            <h4>Enlaces</h4> 
            <ul> 
                <li><a href="http://google.es"> Fotos</a></li> 
                <li><a href="http://google.es" target="_blank">Google</a></li> 
            </ul> 
        </div> 
        <div id="centro">
            <img width="200" height="125" src='<c:url value="/imagenes/grupocursojava.jpg" />'/>
            Textos varios
        </div>
        <div id="pie1">
            <a href="principal.html">Principal</a>
        </div>
    </body>
</html>
