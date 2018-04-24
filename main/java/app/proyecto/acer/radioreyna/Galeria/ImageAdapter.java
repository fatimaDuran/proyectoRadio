package app.proyecto.acer.radioreyna.Galeria;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import app.proyecto.acer.radioreyna.R;

/**
 * Created by ACER on 12/04/2018.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    public  Integer[] images={
            R.drawable.grupal,R.drawable.museo,
            R.drawable.museo1,R.drawable.museo2,
            R.drawable.museo3,R.drawable.museo4,
            R.drawable.museo5,R.drawable.museo6,
            R.drawable.museo7,R.drawable.imagi1,
            R.drawable.cantante,R.drawable.cantate1,
            R.drawable.cantante2,R.drawable.cantante3


    };
    public ImageAdapter(Context e) {

        context = e;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;
    }
}
