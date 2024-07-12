package mx.edu.utez.pruebaf.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.practica3e.dao.UsuarioDao;
import mx.edu.utez.practica3e.model.Usuario;

import java.io.IOException;
import java.util.List;

@WebServlet(name="EjemploXHTMLRequestServlet",value = "/usuario")
public class EjemploXHTMLRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDao dao = new UsuarioDao();
        List<Usuario> lista = dao.getAll();
        Gson gson = new Gson();
        String json = gson.toJson(lista);

        resp.setContentType("text/json");
        resp.getWriter().write(json);
    }
}
