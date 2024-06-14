package mx.edu.utez.pruebaf.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.pruebaf.dao.UserDao;
import mx.edu.utez.pruebaf.model.User;

import java.io.IOException;

//el parametro de value es la ruta para llegar a este servlet
//Debe de comenzar con una / y la ruta que tu quieras
//Nota no le vayan a poner espacios
@WebServlet(name="UserServlet",value="/login")
public class UserServlet extends HttpServlet{


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //Normalmente siempre ocupen el método doPost
    //Para información de formularios
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // el objeto req contiene toda la información
        // que proviene del jsp

        //Es que el método doPost haga el inicio de sesión
        String user = req.getParameter("user");
        // ^ esto funciona siii, el input del form
        // tiene el name = "user"
        String contra = req.getParameter("contra");

        //En este punto solo tengo los valores de los inputs
        // Me hace falta llamar a un archivo para ver si existe
        // o no el usuario en la base de datos
        UserDao dao = new UserDao();
        User usuario = dao.getOne(user, contra);

        //Imprimir el nombre del usuario en la base de datos
        //Si no existe el usuario entonces imprime null
        System.out.println(usuario.getNombre());
        String ruta = "index.jsp";
        HttpSession sesion = req.getSession();
        if(usuario.getNombre() == null){
            //Entonces no voy a poder iniciar sesión
            sesion.setAttribute("mensaje", "El usuario no existe en la base de datos");
        }else{
            //Entonces si inicie la sesión
            ruta = "bienvenido.jsp";
            sesion.removeAttribute("mensaje");
            sesion.setAttribute("usuario", usuario);
        }
        resp.sendRedirect(ruta);
    }

    public void destroy() {

    }

    public void init() throws ServletException {

    }
}
