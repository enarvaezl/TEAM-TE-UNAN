package com.example.enarvaez.basedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BienvenidoActivity extends AppCompatActivity {
public static final  String registro_user="name";
TextView txtuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);


        txtuser=(TextView)findViewById(R.id.txtusr);
        String user=getIntent().getStringExtra("name");
        txtuser.setText("!!Bienvenido  "+  user +"!!");



    }
}
