package app.proyecto.acer.radioreyna.Eventos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.proyecto.acer.radioreyna.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ACER on 11/04/2018.
 */

public class Adaptador extends BaseAdapter {
    Context contexto;
    List<DatosE> ListaOjetos;

    public Adaptador(Context contexto, List<DatosE> listaOjetos) {
        this.contexto = contexto;
        ListaOjetos = listaOjetos;
    }

    @Override
    public int getCount() {
        return ListaOjetos.size();
    }

    @Override
    public Object getItem(int position) {
        return ListaOjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ListaOjetos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista =convertView;
        LayoutInflater inflater=LayoutInflater.from(contexto);
        vista= inflater.inflate(R.layout.itemlistview,null);

        CircleImageView imagen=(CircleImageView) vista.findViewById(R.id.imageView);
        TextView titulo=(TextView) vista.findViewById(R.id.textTitulo);
        TextView detalle=(TextView)vista.findViewById(R.id.textDescricion);

        titulo.setText(ListaOjetos.get(position).getTitulo());
        detalle.setText(ListaOjetos.get(position).getDetalle());
        imagen.setImageResource(ListaOjetos.get(position).getImagen());
        return vista;
    }
}
