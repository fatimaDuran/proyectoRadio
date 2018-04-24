package app.proyecto.acer.radioreyna.Eventos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import app.proyecto.acer.radioreyna.R;

public class DetalleEctivity extends AppCompatActivity {
    ImageView foto;
    TextView titulo;
    TextView detalle;
    TextView evento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ectivity);

        foto=(ImageView) findViewById(R.id.imagFoto);
        titulo=(TextView) findViewById(R.id.textTitulo);
        detalle=(TextView) findViewById(R.id.textDetalle);
        evento=(TextView) findViewById(R.id.textEvento) ;


        DatosE obj =(DatosE) getIntent().getExtras().getSerializable("objeto");

        titulo.setText(obj.getTitulo());
        detalle.setText(obj.getDetalle());
        evento.setText(obj.getEvento());
        foto.setImageResource(obj.getImagen());
    }
}
