package mx.edu.utez.pruebaf.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.pruebaf.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "BorrarUserServlet", value = "/delete")
public class BorrarUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao dao=new UserDao();
        if(dao.deleteLogico(id)){
            resp.sendRedirect("gestionUsuario.jsp");
        }else{
            req.getSession().setAttribute("mensaje","No se pudo borrar el usuario");
            resp.sendRedirect("index.jsp");
        }
    }
}
