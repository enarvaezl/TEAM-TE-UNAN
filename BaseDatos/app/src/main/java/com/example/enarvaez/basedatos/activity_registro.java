package com.example.enarvaez.basedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class activity_registro extends AppCompatActivity {



    private EditText TextEmail;
    private EditText TextPassword;
    private Button btnRegistrar;
    private ProgressBar progresoDialogo;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth=FirebaseAuth.getInstance();

        TextEmail=(EditText) findViewById(R.id.txtcorreo);
        TextPassword= (EditText) findViewById(R.id.txtcorreo);
        btnRegistrar=(Button)findViewById(R.id.btnRegistro);
        //progresoDialogo= new progresoDialogo(this);





    }
}
