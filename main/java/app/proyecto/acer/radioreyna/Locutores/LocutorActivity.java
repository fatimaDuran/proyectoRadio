package app.proyecto.acer.radioreyna.Locutores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import app.proyecto.acer.radioreyna.R;

public class LocutorActivity extends AppCompatActivity {
    ListView listaDatos;
    ArrayList<DatosL> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locutor);
        listaDatos=(ListView)findViewById(R.id.lstDatos);
        Lista=new ArrayList<DatosL>();

        Lista.add(new DatosL(1,"Gerente Sergio Reyna López",R.drawable.gerente));
      Lista.add(new DatosL(2,"Ana Luisa Gutiérrez",R.drawable.ana));
        Lista.add(new DatosL(3,"Francisco Castillo",R.drawable.franci));
       Lista.add(new DatosL(4,"Gabriel de Jesús Rodríguez",R.drawable.gabi));
       Lista.add(new DatosL(5,"Juan Antonio Tovar",R.drawable.juan));
        Lista.add(new DatosL(6,"Luis Ángel Tovar Camacho.",R.drawable.luis));
        Lista.add(new DatosL(7,"Marco Antonio Ledesma",R.drawable.marco));
        Lista.add(new DatosL(8, "José Cruz Guerra Brito",R.drawable.jose));
        Lista.add(new DatosL(9,"Ricardo López",R.drawable.ricardo));
       Lista.add(new DatosL(10,"Verónica Beretnice Reyna.",R.drawable.veronica));
        Lista.add(new DatosL(11,"Wolstano Franco.",R.drawable.franco));


                AdaptadorL miadaptador =new AdaptadorL(getApplicationContext(),Lista);
                listaDatos.setAdapter(miadaptador);

                listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DatosL obj =(DatosL) parent.getItemAtPosition(position);
                    }
        });
    }
}
