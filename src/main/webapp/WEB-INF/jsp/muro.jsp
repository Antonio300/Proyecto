<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muro de usuario</title>
        <link rel="stylesheet" media="screen" type="text/css" href="css/plantilla.css" />
    </head>
    <body>
        <div id="cabecera1">
            <table>
                <tr>
                    <td width="50%">
                        <img width="200" height="150" src='<c:url value="/imagenes/grupocursojava.jpg" />'/>
                    </td >
                    <td>
                        <p id="rotulo">
                            Bienvenido al muro de ${usuario.nombre}
                        </p>
                        <br>
                        <br>
                        <p id="link1">
                            <a href="principal.html">Principal</a>
                        </p>
                    </td>
                </tr>
            </table>
        </div>
        <div id="invitados">
            <div id="recuadro1">
                <h4 id= "h3primero"> Amigos invitados: ${numeroInvitados}.</h4>
                <c:if test="${numeroInvitados != 0}">
                    <ul>
                        <c:forEach items="${invitados}" var="invitado">
                            <ul>
                                ${invitado.nombre}
                            </ul>
                            <br>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
            <br>
            <div id="recuadro2">
                <h4 id= "h3segundo">Elige nuevos amigos.</h4>
                <ul>
                    <c:forEach items="${posibles}" var="posible">
                        <ul>
                            <a href="amigo.html?ident1=${usuario.id}&ident2=${posible.id}"> ${posible.nombre}</a>
                        </ul>
                        <br>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <br>
        <div id="contenido1">
            <div id="recuadro3">
                <c:if test="${vacio == true}">
                    <h4 id= "h3contenido" ALIGN ="center">No tienes contenidos.</h4>
                </c:if>
                <c:if test="${vacio == false}">

                    <h4 id= "h3tercero" ALIGN ="center">Contenidos del muro de ${usuario.nombre}.</h4>
                    <ul>
                        <c:forEach items="${contenidos}" var="contenido">
                            <div id="contenidotext">
                                <ul>
                                    ${contenido.texto}
                                </ul>
                            </div>
                            <br>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
            <br>
            <div id="recuadro4">
                <form:form modelAttribute="contenido" action="publicar.html?ident=${usuario.id}">
                    <table>
                        <tr>
                            <td id="publica"> Publica un nuevo contenido:</td>
                            <td>
                                <form:input path="texto"/>
                            </td>
                            <td>
                                <form:errors path="texto"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                               
                                <input type="submit" value="Publicar" />
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>  
        </div>   
    </body>
</html>

