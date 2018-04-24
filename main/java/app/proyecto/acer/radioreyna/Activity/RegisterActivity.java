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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import app.proyecto.acer.radioreyna.Entities.Usuario;
import app.proyecto.acer.radioreyna.MainActivity;
import app.proyecto.acer.radioreyna.R;

//import app.proyecto.acer.radioreyna.R;

/**
 * Created by aurelio   enriquez on 15/03/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText txtName,txtEmail,txtPassword,txtReapetPassword;
    private Button btnRegister,btnRegister1;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtName = (EditText) findViewById(R.id.idRegisterName);
        txtEmail = (EditText) findViewById(R.id.idRegisterEmail);
        txtPassword = (EditText) findViewById(R.id.idRegisterPassword);
        txtReapetPassword = (EditText) findViewById(R.id.idRegisterReapetPassword);
        btnRegister = (Button) findViewById(R.id.idRegister);
       btnRegister1 = (Button) findViewById(R.id.idRegisterInvit);



        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String correo = txtEmail.getText().toString();
                final String nombre = txtName.getText().toString();
                if(isValidEmail(correo) && validatePassword() && validateName(nombre)){
                    String contraseña = txtPassword.getText().toString();
                    mAuth.createUserWithEmailAndPassword(correo, contraseña)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(RegisterActivity.this, "Se registro correctamente.", Toast.LENGTH_SHORT).show();
                                        nextActivity1();

                                        Usuario usuario = new Usuario();
                                        usuario.setCorreo(correo);
                                        usuario.setNombre(nombre);
                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        DatabaseReference reference = database.getReference("Usuarios/" + currentUser.getUid());
                                        reference.setValue(usuario);
                                        finish();


                                        // If sign in fails, display a message to the user.

                                    }else{
                                        Toast.makeText(RegisterActivity.this, "Error al registrarse.", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            });
                }else{
                    Toast.makeText(RegisterActivity.this, "Debe registrarse o el correo ya existe!.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnRegister1.setOnClickListener(new View.OnClickListener() {
            final String correo = txtEmail.getText().toString();
            public void onClick(View view) {
                nextActivity1();

            }

        });


    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }





    public boolean validatePassword(){ //metodo de validacion
        String password,repeatedPassword;
        password = txtPassword.getText().toString();
        repeatedPassword = txtReapetPassword.getText().toString();
        if (password.equals(repeatedPassword)){
            //la contrase'a debe ser mayor a 6 y menor a 12
            if (password.length()>=6 && password.length()<=12){
                return true;

            }else return false;

        }else return false;

    }



    public boolean validateName(String name){
        return !name.isEmpty();}  //el nombre no debe estar vacio



    private void nextActivity1(){
        startActivity(new Intent(RegisterActivity.this,MainActivity.class));

    }

}



