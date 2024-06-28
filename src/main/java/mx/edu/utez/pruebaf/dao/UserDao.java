package mx.edu.utez.pruebaf.dao;

import mx.edu.utez.pruebaf.model.User;
import mx.edu.utez.pruebaf.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            con.close();
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
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return respuesta;
    }

    public ArrayList<User> getAll(){
        ArrayList<User> lista = new ArrayList<>();
        String query = "select * from users";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("Id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setContra(rs.getString("contra"));
                u.setCodigo(rs.getString("codigo"));
                u.setEstado(rs.getBoolean("estado"));
                lista.add(u);
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    //Update <-- aveces se apoya de otro metodo getOne
    public boolean update(User u){
        boolean flag = false;
        String query = "update users set nombre=?,contra=sha2(?,256),correo=? where id=?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getContra());
            ps.setString(3,u.getCorreo());
            ps.setInt(4,u.getId());
            if(ps.executeUpdate()>0){
                //Que si se hizo la modificación o modificaciones
                flag = true;
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public User getOne(int id) {
        User u = new User();
        String query = "select * from users where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setNombre(rs.getString("nombre"));
                u.setContra(rs.getString("contra"));
                u.setCorreo(rs.getString("correo"));
                u.setId(rs.getInt("id"));
            }
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    //Delete
    public boolean deleteFisico(int id) {
        boolean flag = false;
        String query = "delete from users where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                flag = true;
            }
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteLogico(int id) {
        boolean flag = false;
        String query = "update users set estado = false where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                flag = true;
            }
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

}
