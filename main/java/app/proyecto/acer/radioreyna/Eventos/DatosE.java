package app.proyecto.acer.radioreyna.Eventos;

import java.io.Serializable;

/**
 * Created by ACER on 11/04/2018.
 */

public class DatosE  implements Serializable{
    private int Id;
    private String Titulo;
    private  String Detalle;
    private String  Evento;
    private int Imagen;

    public DatosE(int id, String titulo, String detalle, String evento, int imagen) {
        Id = id;
        Titulo = titulo;
        Detalle = detalle;
        Evento = evento;
        Imagen = imagen;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public String getEvento() {
        return Evento;
    }

    public void setEvento(String evento) {
        Evento = evento;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}

