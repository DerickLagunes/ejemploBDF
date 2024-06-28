<%@ page import="mx.edu.utez.pruebaf.dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="mx.edu.utez.pruebaf.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/CSS/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/CSS/datatables.css">
</head>
<body>
    <table id="example" class="table table-striped table-hover" style="width: 100%">
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
                    <td><a href="delete?id=<%=u.getId()%>">Eliminar</a></td>
                </tr>
               <% } %>
        </tbody>
    </table>
    <script src="${pageContext.request.contextPath}/JS/jquery-3.7.0.js"></script>
    <script src="${pageContext.request.contextPath}/JS/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/JS/datatables.js"></script>
    <script src="${pageContext.request.contextPath}/JS/dataTables.bootstrap5.js"></script>
    <script src="${pageContext.request.contextPath}/JS/es-MX.json"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const table = document.getElementById('example');
            new DataTable(table, {
                language: {
                    url: '${pageContext.request.contextPath}/JS/es-MX.json'
                }
            });
        });
    </script>
</body>
</html>
