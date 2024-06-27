<%@ page import="mx.edu.utez.pruebaf.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HttpSession sesion = request.getSession();
        User u = (User) sesion.getAttribute("usuario");
        if(u != null) { %>
    <!-- Entonces quiero actualizar -->
    <form method="post" action="sign_in">
        <label>Ingrese su nombre: </label>
        <input type="text" name="nombre" required value="<%=u.getNombre()%>">
        <br>
        <label>Ingrese su correo: </label>
        <input type="email" name="correo" required value="<%=u.getCorreo()%>">
        <br>
        <label>Ingrese su contraseña: </label>
        <input type="password" name="contra" required value="<%=u.getContra()%>">
        <br>
        <input type="hidden" name="operacion" value="actualizar">
        <input type="hidden" name="id" value="<%=u.getId()%>" >
        <input type="submit" value="Actualizar">
    </form>
       <% } else { %>
    <!-- Este es el de registro -->
    <form method="post" action="sign_in">
        <label>Ingrese su nombre: </label>
        <input type="text" name="nombre" required>
        <br>
        <label>Ingrese su correo: </label>
        <input type="email" name="correo" required>
        <br>
        <label>Ingrese su contraseña: </label>
        <input type="password" name="contra1" required>
        <br>
        <label>vuelva a introducir su contraseña: </label>
        <input type="password" name="contra2" required>
        <br>
        <input type="hidden" name="operacion" value="registrar">
        <input type="submit" value="Registrarse">
    </form>
<% } %>
<%
    sesion.removeAttribute("usuario");
%>
</body>
</html>
