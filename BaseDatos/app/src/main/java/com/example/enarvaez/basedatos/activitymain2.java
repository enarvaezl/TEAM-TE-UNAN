package com.example.enarvaez.basedatos;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class activitymain2 extends AppCompatActivity {


    ImageButton btn_nivelUsuario ,btn_nivelInvitado;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        btn_nivelUsuario= (ImageButton)findViewById(R.id.imgbtsesion);
        btn_nivelInvitado= (ImageButton)findViewById(R.id.imgbtinvitado);

        btn_nivelUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(activitymain2.this,IniciarSesion.class);
                startActivity(entrar);
            }


        });
        btn_nivelInvitado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(activitymain2.this,ModulosGSM.class);
                startActivity(entrar);
            }


        });

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
