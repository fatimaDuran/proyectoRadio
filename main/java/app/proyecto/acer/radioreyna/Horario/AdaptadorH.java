package app.proyecto.acer.radioreyna.Horario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.proyecto.acer.radioreyna.R;

/**
 * Created by ACER on 12/04/2018.
 */

public class AdaptadorH extends BaseAdapter {

    Context contexto;
    List<DatoH> ListaOjetos;

    public AdaptadorH(Context contexto, List<DatoH> listaOjetos) {
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
        vista=inflater.inflate(R.layout.lmhori,null);
        TextView horario=(TextView) vista.findViewById(R.id.textHorario);
        TextView programa=(TextView) vista.findViewById(R.id.textPrograma);
        TextView locutor=(TextView) vista.findViewById(R.id.textLocutor);


        horario.setText(ListaOjetos.get(position).getHorario());
        programa.setText(ListaOjetos.get(position).getPrograma());
        locutor.setText(ListaOjetos.get(position).getLocutor());

        return vista;
    }
}
