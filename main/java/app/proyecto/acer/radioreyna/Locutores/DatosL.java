package app.proyecto.acer.radioreyna.Locutores;

import java.io.Serializable;

/**
 * Created by ACER on 11/04/2018.
 */

public class DatosL implements Serializable {
    private int Id;
    private String Nombre;
    private int Imagen;

    public DatosL(int id, String nombre, int imagen) {
        Id = id;
        Nombre = nombre;
        Imagen = imagen;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
