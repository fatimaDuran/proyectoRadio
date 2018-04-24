package app.proyecto.acer.radioreyna.Galeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import app.proyecto.acer.radioreyna.R;

public class FullmageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullmage);


        Intent intent = getIntent();

        int position = intent.getExtras().getInt("id");
        ImageAdapter adapter=new ImageAdapter(this);

        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(adapter.images[position]);
    }
}
