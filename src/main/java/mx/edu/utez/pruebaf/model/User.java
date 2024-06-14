package mx.edu.utez.pruebaf.model;

public class User {
    private String nombre;
    private String contra;

    //Constructor vacio
    public User(){}
    public User(String nombre, String contra){
        this.nombre = nombre;
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
