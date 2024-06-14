<%@ page import="mx.edu.utez.pruebaf.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HttpSession sesion = request.getSession();
        User user = (User) sesion.getAttribute("usuario");
        if(user != null) {//Si tenemos un incio de sesión valido
    %>
    <h1>Bienvenido Usuario: <%=user.getNombre()%></h1>
    <h2>Eres un usuario legitimo que inicio sesión correctamente</h2>
    <h3>estamos orgulllosos de ti :,)</h3>
    <%
        }else{//Que alguien se esta portando mal (no paso por el servlet)
    %>

    <h1>No tienes permiso para ver esta página</h1>
    <a href="index.jsp">Iniciar sesión</a>
    <%
        }
    %>
</body>
</html>
