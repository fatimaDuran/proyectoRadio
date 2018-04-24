package app.proyecto.acer.radioreyna;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

import app.proyecto.acer.radioreyna.Activity.Messages1Activity;
import app.proyecto.acer.radioreyna.Eventos.EventoActivity;
import app.proyecto.acer.radioreyna.Galeria.GaleriaActivity;
import app.proyecto.acer.radioreyna.Horario.HorarioActivity;
import app.proyecto.acer.radioreyna.Locutores.LocutorActivity;
import app.proyecto.acer.radioreyna.Ubicasion.MapsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int cont = 0;

    Button btn_play,btn_eliminar;
    MediaPlayer mediaPlayer;
    boolean prepared = false;
    boolean started = false;

    String stream = "http://icecasthd.net:25720/radioreyna";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btn_play =  (Button)  findViewById(R.id.btn_play);
        btn_eliminar =  (Button)  findViewById(R.id.btn_eliminar);
        btn_play.setEnabled(false);
        btn_play.setText("CARGANDO");

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        new PlayerTask().execute(stream);

        btn_play.setOnClickListener(new  View.OnClickListener() {


            @Override
            public void onClick(View view){
                if (started) {
                    started = false;
                    mediaPlayer.pause();
                    btn_play.setText("PLAY");

                }else{
                    started = true;
                    mediaPlayer.start();
                    btn_play.setText("PAUSE");
                }

            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("chatV2").removeValue();
            }
        });





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    class  PlayerTask extends AsyncTask<String, Void, Boolean> {


        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                prepared = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  prepared;

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mediaPlayer.start();
            btn_play.setEnabled(true);
            btn_play.setText("PLAY");
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (started){
            mediaPlayer.start();
        }
    }

   /* @Override
    protected void onRestart() {
        super.onRestart();
    }*/



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_chat) {
            startActivity(new Intent(this, Messages1Activity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, GaleriaActivity.class));





        } else if (id == R.id.nav_share) {
                    Intent intent =new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, "RadioReyna http://radioreyna.net/Programacin");
                    startActivity(Intent.createChooser(intent,"compartir"));
        }
        else if (id == R.id.nav_map) {
            startActivity(new Intent(this, MapsActivity.class));
        }
        else if (id == R.id.nav_evet) {
            startActivity(new Intent(this, EventoActivity.class));
        }
        else if (id == R.id.nav_locutor) {
            startActivity(new Intent(this, LocutorActivity.class));
        }


        else if (id == R.id.nav_horario) {
            startActivity(new Intent(this, HorarioActivity.class));
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
