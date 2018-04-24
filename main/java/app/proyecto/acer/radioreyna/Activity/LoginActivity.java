package app.proyecto.acer.radioreyna.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import app.proyecto.acer.radioreyna.R;


/**
 * Created by user on 19/02/2018. 19
 */

public class LoginActivity extends AppCompatActivity {

    private EditText txtCorreo,txtContraseña;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtCorreo = (EditText) findViewById(R.id.idEmailLogin);
        txtContraseña = (EditText) findViewById(R.id.idPasswordLogin);
        btnLogin = (Button) findViewById(R.id.idLoginLogin);


        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = txtCorreo.getText().toString();
                if(isValidEmail(correo) && validarContraseña()){
                    String contraseña = txtContraseña.getText().toString();
                    mAuth.signInWithEmailAndPassword(correo, contraseña)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(LoginActivity.this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
                                        //nextActivity();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginActivity.this, "Error en el correo.", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }else{
                    Toast.makeText(LoginActivity.this, "El correo ya existe o la contraseña esta mal.", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean validarContraseña(){
        String contraseña;
        contraseña = txtContraseña.getText().toString();
        if(contraseña.length()>=6 && contraseña.length()<=16){
            return true;
        }else return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            Toast.makeText(this, "Bienvenido.", Toast.LENGTH_SHORT).show();
           // nextActivity();
        }
    }

   /* private void nextActivity() {
        startActivity(new Intent(LoginActivity.this, MessagesActivity.class));
    }*/
    private void nextActivityRegist() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    @Override
    public void onBackPressed() {
     nextActivityRegist();
    }
}
