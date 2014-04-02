<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link rel="stylesheet" media="screen" type="text/css" href="css/plantilla0.css" />
    </head>
    <body>
        <div id="cabecera1">
            <h1 ALIGN = "center">Bienvenido a nuestra red social</h1>
        </div>
        <div id="centro">
            <div id="identificacion1">              
               <h2>Identificación.</h2>
                <form:form modelAttribute="usuario" action="identificacion.html">
                    <table>
                        <tr>
                            <td>Nombre de usuario:</td>
                            <td>
                                <form:input path="nombre"/>
                            </td>
                            <td>
                                <form:errors path="nombre"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Clave de acceso:</td>
                            <td>
                                <form:input path="clave"/>
                            </td>
                            <td>
                                <form:errors path="clave"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <br>
                                <input type="submit" value="Aceptar"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
            <br>
            <br>
            <div id="identificacion2">
                <h2>Crear cuenta.</h2>
                <form:form commandName="usuario" action="cuentanueva.html">
                    <table>
                        <tr>
                            <td>Nombre de usuario:</td>
                            <td>
                                <form:input path="nombre"/>
                            </td>
                            <td>
                                <form:errors path="nombre"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Clave de acceso:</td>
                            <td>
                                <form:input path="clave"/>
                            </td>
                            <td>
                                <form:errors path="clave"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <br>
                                <input type="submit" value="Aceptar"/>
                            </td>
                        </tr>
                    </table>
                </form:form>  
            </div>
        </div>
    </body>
</html>
