package mx.edu.utez.pruebaf.dao;

import mx.edu.utez.pruebaf.model.User;
import mx.edu.utez.pruebaf.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User getOne(String user, String contra){
        User u = new User();
        String query = "select * from users where nombre = ? and contra = sha2(?,256)";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, contra);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setNombre(rs.getString("nombre"));
                u.setContra(rs.getString("contra"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public boolean insert(User u){
        boolean respuesta = false;
        String query = "insert into users(nombre,correo,contra) values(?,?,sha2(?,256))";
        try{
            //1)Conectarme a la BD
            Connection con = DatabaseConnectionManager.getConnection();
            //2)Preparar la query
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getCorreo());
            ps.setString(3,u.getContra());
            //3)Ejecutar el query
            if(ps.executeUpdate()>0){
                //Si se hizo la inserción
                respuesta = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return respuesta;
    }

}
