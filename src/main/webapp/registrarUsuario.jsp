<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
        <input type="submit" value="Registrarse">
    </form>
</body>
</html>
