package mx.edu.utez.pruebaf.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.pruebaf.utils.DatabaseConnectionManager;
import net.sf.jasperreports.engine.JasperRunManager;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="PdfServlet",value="/pdf")
public class PdfServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Seleccinar una imagen de los assets (logo)
        String ruta = "/img/Logo.png";
        File imagen = new File(getServletContext().getRealPath(ruta));
        FileInputStream archivo = new FileInputStream(imagen);

        //Obtener ubicación y bytes del reporte
        String report = "/WEB-INF/reporteF.jasper";
        File file = new File(getServletContext().getRealPath(report));
        InputStream input = new FileInputStream(file);

        //Colocar los parametros del reporte
        Map mapa = new HashMap();
        mapa.put("Logo", archivo);


        //obtener una coneccion a los datos
        Connection con = null;
        try {
            con = DatabaseConnectionManager.getConnection();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Configura como se va a ver la respuesta del Servlet
        resp.setContentType("application/pdf");  //Establecer el tipo de respuesta
        resp.setHeader("Content-Disposition", "Attachment; filename=reporteF.pdf");  //esto es para forzar la descarga del archivo

        //Generar el reporte
        try {
            byte[] bytes = JasperRunManager.runReportToPdf(input, mapa, con);
            OutputStream os = resp.getOutputStream();
            os.write(bytes);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
