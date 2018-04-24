package app.proyecto.acer.radioreyna.Horario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import app.proyecto.acer.radioreyna.R;

public class HorarioActivity extends AppCompatActivity {
    ListView listaDatoH;
    ArrayList<DatoH> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        listaDatoH=(ListView)findViewById(R.id.lstDatos);
        Lista=new ArrayList<DatoH>();

        Lista.add(new DatoH(1," Lunes a Viernes :06:00 A 09:30 HRS."," Programa:Arriba corazones: catalogo en español, trios, sonoras, solistas, orquestas " +
                "y grupos de los años 50`s, 60`s y 70`s"," Locutor:Wolstano Franco"));
        Lista.add(new DatoH(2," Lunes a Viernes :09:30 A 11:00 HRS"," Programa:Expresion ciudadana. Noticias, entrevistas y " +
                "participación ciudadana con telefono abierto.  "
                ," Locutor:Wolstano Francisco Castillo"));
        Lista.add(new DatoH(3," Lunes a Viernes :12:00 A 13:00 HRS."," Programa:El club de radio reyna musica variada y concursos   " ," Locutor: Francisco Castillo "));
        Lista.add(new DatoH(4," Lunes a Viernes :13:00 A 14:00 HRS.", " Programa:Arriba el norte musica norteña"," Locutor:\tFrancisco Castillo"));
        Lista.add(new DatoH(5," Lunes a Viernes :14:00 A 16:00 HRS.", " Programa:Fuerza Grupera, música grupera"," Locutor:\t\tJuan Cervantes"));
        Lista.add(new DatoH(6," Lunes a Viernes :16:00 A 19:00 HRS.", " Programa:Fuerza Grupera, música grupera"," Locutor:\tAna Luisa Guitierrez"));
        Lista.add(new DatoH(7," Lunes a Viernes :19:00 A 20:00 HRS.", " Programa:La hora de Vicente y Alejandro Fernandez, Musica ranchera"," Locutor:\tna Luisa Guitierrez"));
        Lista.add(new DatoH(8," Lunes a Viernes :20:00 A 22:00 HRS.", " Programa:Las grandes de siempre, " +
                "musica romantica del catalogo en español"," Locutor:\tJuan Antonio Tovar"));
        Lista.add(new DatoH(9," Lunes a Viernes :22:00 A 24:00 HRS.", " Programa:Las grandes de siempre, musica" +
                " romantica del catalogo en español"," Locutor:\tJuan Antonio Tovar"));



        Lista.add(new DatoH(10," Sabados :06:00 A 10:00 HRS."," Programa:Arriba corazones: catalogo en español, trios, sonoras, solistas, " +
                "orquestas y grupos de los años 50`s, 60`s y 70`s   " ," Locutor: Francisco Castillo "));

        Lista.add(new DatoH(11," Sabados :10:00 A 12:00 HRS.",
                " Programa:Lo más reciente del pop.  " ," Locutor: \tJuan Cervantes "));
        Lista.add(new DatoH(12," Sabados :12:00 A 13:00 HRS.",
                " Programa:Musica con Ricardo López Musica disco de los 80´s.  " ," Locutor: \tRicardo López "));
        Lista.add(new DatoH(13," Sabados :13:00 A 14:00 HRS.",
                " Programa:Lo mas reciente del pop, Musica Pop  " ," Locutor: \tJuan Cervantes "));

        Lista.add(new DatoH(14," Sabados :14:00 A 15:00 HRS.",
                " Programa:Fuerza Grupera, música grupera " ," Locutor: \tJuna Antonio Tovar Hernández "));
        Lista.add(new DatoH(15," Sabados :15:00 A 16:00 HRS.",
                " Programa:Grupeando con musica grupera y concursos  " ," Locutor: \tJuan Antonio Tovar "));

        Lista.add(new DatoH(16," Sabados :16:00 A 18:00 HRS.",
                " Programa:Mas alla de la frontera, musica grupera y recepcion de llamadas  " ," Locutor: \tJuan Antonio Tovar "));
        Lista.add(new DatoH(17," Sabados :18:00 A 20:00 HRS.",
                " Programa: Las grandes de siempre," +
                        " musica romantica del catalogo en español  " ," Locutor: \tGabriel Jesus Rodriguez Aguilar "));
        Lista.add(new DatoH(18," Sabados :20:00 A 22:00 HRS.",
                " Programa:Especial Jose Alfredo Jimenez, musica mexicana  " ," Locutor: \tAlma Delia Tovar Hernandez "));



        Lista.add(new DatoH(19," Domingos :06:00 A 08:00 HRS.",
                " Programa:Arriba corazones: catalogo en español, trios, sonoras, solistas, " +
                        "orquestas y grupos de los años 50`s, 60`s y 70`s  " ," Locutor: \tWolstano Franco "));

        Lista.add(new DatoH(20," Domingos :08:00 A 10:00 HRS.",
                " Programa:Domingos del recuerdo, musica de trios.," ,"Locutor: \tWolstano Franco "));

        Lista.add(new DatoH(21," Domingos :10:00 A 11:00 HRS.",
                "Programa:Carrusel de la alegria, musica y cuentos infantiles" ," Locutor: \t Gabriel Jesús Rodríguez Aguilar"));

        Lista.add(new DatoH(22," Domingos :11:00 A 13:00 HRS.",
                " Programa: Epocas 1370, musica de los 70´s, 80´´s y 90´s  " ," Locutor: \tAlejandro Corpus "));
        Lista.add(new DatoH(23," Domingos :13:00 A 14:00 HRS.",
                " Programa:Musica variada"," Locutor: \tAna Luisa Gutierrez "));

        Lista.add(new DatoH(24," Domingos :14:00 A 18:00 HRS.",
                " Programa:Las grandes inolvidables, musica grupera"," Locutor: \tJuan Antonio Tovar "));
        Lista.add(new DatoH(25," Domingos :18:00 A 22:00 HRS.",
                " Programa:Las grandes de siempre, muisca de catalogo en español"," Locutor: \tGabriel Jesus Rodriguez Aguilar "));
        Lista.add(new DatoH(26," Domingos :22:00 A 23:00 HRS.",
                " Programa:Hora Nacional"," Locutor: \tGabriel Jesus Rodriguez Aguilar "));
        Lista.add(new DatoH(27," Domingos :23:00 A 24:00 HRS.",
                " Programa: Las grandes de siempre, musica de catalogo en español",
                         "Locutor: \tGabriel Jesus Rodriguez Aguilar "));


        AdaptadorH miadaptador =new AdaptadorH(getApplicationContext(),Lista);
        listaDatoH.setAdapter(miadaptador);


    }
}
