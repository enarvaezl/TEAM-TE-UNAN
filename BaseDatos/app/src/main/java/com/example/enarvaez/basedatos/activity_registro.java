package com.example.enarvaez.basedatos;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public  class activity_registro extends AppCompatActivity implements View.OnClickListener {

    private EditText TextEmail;
    private EditText TextPassword;
    private Button btnRegistrar, btnlog;
    private ProgressDialog ProgressDialog;


    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth = FirebaseAuth.getInstance();

        TextEmail = (EditText) findViewById(R.id.txtcorreo);
        TextPassword = (EditText) findViewById(R.id.txtcorreo);
        btnRegistrar = (Button) findViewById(R.id.btnRegistro);
        btnlog = (Button) findViewById(R.id.btnlogin);

        ProgressDialog = new ProgressDialog(this);

        btnRegistrar.setOnClickListener(this);

    }

    private void registrar_usuario() {

        //obtenemos el email de la caja de texto y la contraseña de las cajas de texto

        String email = TextEmail.getText().toString().trim();
        String pass = TextPassword.getText().toString().trim();

        //Verifico si las cajas de texto estan vacias
        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "se debe ingresar un email valido", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {

            Toast.makeText(this, "Se debe ingresar una contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        ProgressDialog.setMessage("Registrando Usuario");
        ProgressDialog.show();

        //creando un nuevo usuario
        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
            //Verificacion del proceso de creacion de usuario
                if (task.isSuccessful()) {

                    Toast.makeText(activity_registro.this, "se ha registrado el Email :"+ TextEmail.getText(), Toast.LENGTH_LONG).show();
                } else {

                    //validamos si el usuario ya exste en la base de datos
                    if(task.getException() instanceof FirebaseAuthException)
                    {

                       Toast.makeText(activity_registro.this,"Usuario ya existe",Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(activity_registro.this, "No se ha podido ingresar el usuario", Toast.LENGTH_LONG).show();

                }

                ProgressDialog.dismiss();
            }
        });
    }

    private void loguear_usuario()
    {
        //obtenemos el email de la caja de texto y la contraseña de las cajas de texto

        final String email = TextEmail.getText().toString().trim();
        String pass = TextPassword.getText().toString().trim();

        //Verifico si las cajas de texto estan vacias
        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "se debe ingresar un email valido", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {

            Toast.makeText(this, "Se debe ingresar una contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        ProgressDialog.setMessage("Realizando Consulta");
        ProgressDialog.show();

        //Login de  usuario
        firebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                //Verificacion del proceso de creacion de usuario
                if (task.isSuccessful()) {

                    Toast.makeText(activity_registro.this, "Bienvenido :"+ TextEmail.getText(), Toast.LENGTH_LONG).show();

                    Intent welcome=new Intent(getApplication(),BienvenidoActivity.class);
                    welcome.putExtra(BienvenidoActivity.registro_user,email);
                    startActivity(welcome);

                } else {

                    //validamos si el usuario ya exste en la base de datos
                    if(task.getException() instanceof FirebaseAuthException)
                    {

                        Toast.makeText(activity_registro.this,"Usuario ya existe",Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(activity_registro.this, "No se ha podido ingresar el usuario", Toast.LENGTH_LONG).show();

                }

                ProgressDialog.dismiss();
            }
        });
    }





    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnRegistro:

                registrar_usuario();
                break;
            case R.id.btnlogin:
                loguear_usuario();
                break;

        }

    }
}