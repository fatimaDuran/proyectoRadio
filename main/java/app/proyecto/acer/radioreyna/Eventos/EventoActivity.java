package app.proyecto.acer.radioreyna.Eventos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import app.proyecto.acer.radioreyna.R;

public class EventoActivity extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<DatosE> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        listaDatos=(ListView)findViewById(R.id.lstDatos);
        Lista=new ArrayList<DatosE>();

        Lista.add(new DatosE(1,"Gira Radio Reyna","","",R.drawable.event));
        Lista.add(new DatosE(2,"Maraton Del Juguete ","",
                "Una vez más RADIO REYNA se une a la causa llevando a alegrías a cientos de" +
                " niños dolorenses, repartiendo juguetes a quien lo necesita.\n" +
                "\n" +
                "Esta labor no se podría llevar a cabo, si tu ayuda, por eso y mucho más. MIL GRACIAS por aportar con un juguete que es la causa de cientos de alegrías en los niños de nuestra ciudad.",R.drawable.nino));
        Lista.add(new DatosE(3,"Mexico en la nasa","Mexico","“Como joven no debes desistir de tus sueños y debes poner todo de tu parte para lograrlos”, " +
                "recalca el ejemplo de exitoso caso de un mexicano fuera de su país.",R.drawable.mexico));
        Lista.add(new DatosE(4,"Virgen de la Candelaria","Festival","La Fiesta del 2 de Febrero dedicada a la virgen de la Candelaria es una de las mas importnates, " +
                "no solo en Dolores Hidalgo, sino en todo Mexico.",R.drawable.imareyna));
        Lista.add(new DatosE(5,"Ciudades Inteligentes","","",R.drawable.ciudades));
        Lista.add(new DatosE(6,"Feliz Navidad","","",R.drawable.feliz));

        Adaptador miadaptador =new Adaptador(getApplicationContext(),Lista);
        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatosE obj =(DatosE) parent.getItemAtPosition(position);


              //  Intent paso =new Intent(getApplicationContext(),DeatalleActivity.class);
                ///paso.putExtra("objeto",(Serializable)obj);
                //startActivity(paso);

                Intent paso =new Intent(getApplicationContext(),DetalleEctivity.class);
                paso.putExtra("objeto",(Serializable)obj);
                startActivity(paso);

            }
        });


    }
}



