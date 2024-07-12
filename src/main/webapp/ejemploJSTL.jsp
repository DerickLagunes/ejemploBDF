<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Ejemplo con JSTL</title>
</head>
<body>
    <label for="usuario">Seleccione usuario:</label>
    <select id="usuario" name="usuario">
        <option value="" selected disabled>Seleccione...</option>
        <c:forEach items="${usuarios}" var="u">
            <option value="${u.id}" selected disabled>${u.nombre_usuario}</option>
        </c:forEach>
    </select>
</body>
</html>
