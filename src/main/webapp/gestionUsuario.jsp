<%@ page import="mx.edu.utez.pruebaf.dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="mx.edu.utez.pruebaf.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Estado</th>
                <th colspan="2">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                UserDao dao = new UserDao();
                ArrayList<User> lista = dao.getAll();
                for(User u : lista){ %>
                <!-- Se va a repetir -->
                <tr>
                    <td><%=u.getId()%></td>
                    <td><%=u.getNombre()%></td>
                    <td><%=u.getCorreo()%></td>
                    <td><%=u.isEstado() ? "Activo":"Inactivo"%></td>
                    <td><a href="login?id=<%=u.getId()%>">Actualizar</a></td>
                    <td><a>Eliminar</a></td>
                </tr>
               <% } %>
        </tbody>
    </table>
</body>
</html>
