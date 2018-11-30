package com.example.enarvaez.basedatos;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class activity_registro extends AppCompatActivity {

        private EditText TextEmail;
    private EditText TextPassword;
    private Button btnRegistrar;
    private ProgressDialog ProgressDialog;


    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth=FirebaseAuth.getInstance();

        TextEmail=(EditText) findViewById(R.id.txtcorreo);
        TextPassword= (EditText) findViewById(R.id.txtcorreo);
        btnRegistrar=(Button)findViewById(R.id.btnRegistro);
        ProgressDialog= new ProgressDialog(this);

        btnRegistrar.setOnClickListener(this);

    }

    private void registrar_usuario()
    {

        //obtenemos el email de la caja de texto
        String email=TextEmail.getText().toString().trim();
        String pass=TextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"se debe ingresar un email valido",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {

            Toast.makeText(this,"Se debe ingresar una contraseña",Toast.LENGTH_LONG).show();
            return;
        }



        ProgressDialog.setMessage("Registrando Usuario");
        ProgressDialog.show();



        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this)
    }


}
