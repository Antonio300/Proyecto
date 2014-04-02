<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" media="screen" type="text/css" href="css/plantillaresultado.css" />
    </head>
    <body>
        <div id="cabecera0">
            <h1 ALIGN = "center"> Mensajes de error</h1>   
            <div id="link1">
                <a href="principal.html">Principal</a>
            </div>
        </div>
        <div id="centro">
            <div id="cabecera1">
                <div id="error1">
                    <br>
                    ${info}
                </div>
                <div id="usuario1">
                    <ul>
                        Nombre: ${usuario.nombre}
                    </ul>
                    <ul>
                        Clave: ${usuario.clave}
                    </ul>
                </div>
            </div>

            <br>
            <div id="cabecera2">
                <h3>Usuarios existentes</h3>
                <div id="usuario2">
                    <ul>
                        <c:forEach items="${usuarios}" var="usuario">
                            <ul>
                                Nombre: ${usuario.nombre}
                            </ul>
                            <ul>
                                Clave: ${usuario.clave}
                            </ul>
                            <br>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
