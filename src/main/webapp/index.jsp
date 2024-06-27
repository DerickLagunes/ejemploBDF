<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form method="post" action="login">
        <label>Ingrese su usuario: </label>
        <input type="text" name="user">
        <br>
        <label>Ingrese su contraseña: </label>
        <input type="password" name="contra">
        <br>
        <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("mensaje")==null){
                // Significa que aun no existe un atributo mensaje
            } else {
                String mensaje = (String) sesion.getAttribute("mensaje");
        %>
        <p style="color: red"><%=mensaje%></p>
        <%
            }
        %>
        <input type="submit" value="Iniciar sesión">
    </form>
    <a href="registrarUsuario.jsp">Registrar nuevo usuario</a>
    <a href="gestionUsuario.jsp">Ver los usuarios</a>
</body>
</html>