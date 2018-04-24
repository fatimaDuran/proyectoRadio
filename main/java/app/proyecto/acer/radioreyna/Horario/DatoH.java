package app.proyecto.acer.radioreyna.Horario;

import java.io.Serializable;

/**
 * Created by ACER on 12/04/2018.
 */

public class DatoH  implements Serializable{

    private  int Id;
    private String Horario;
    private String Programa;
    private String Locutor;

    public DatoH(int id, String horario, String programa, String locutor) {
        Id = id;
        Horario = horario;
        Programa = programa;
        Locutor = locutor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getPrograma() {
        return Programa;
    }

    public void setPrograma(String programa) {
        Programa = programa;
    }

    public String getLocutor() {
        return Locutor;
    }

    public void setLocutor(String locutor) {
        Locutor = locutor;
    }
}
