package com.example.enarvaez.basedatos;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class portalInformativo extends AppCompatActivity {

    private ImageButton btn_Directorio;
    private ImageButton btn_Servicios;
    private ImageButton btn_Alertas;
    private ImageButton btn_Informativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal_informativo);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        btn_Directorio= (ImageButton)findViewById(R.id.imageBDirectorio5);

        btn_Directorio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(portalInformativo.this,DirectorioCentroMedico.class);
                startActivity(entrar);
            }
        });

        btn_Servicios= (ImageButton)findViewById(R.id.imageBServicio5);

        btn_Servicios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(portalInformativo.this,ServiciosdeConsulta.class);
                startActivity(entrar);
            }
        });

        btn_Alertas= (ImageButton)findViewById(R.id.imageBAlerta5);

        btn_Alertas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(portalInformativo.this,Alertas.class);
                startActivity(entrar);
            }
        });
        btn_Informativo= (ImageButton)findViewById(R.id.imageBInformativo5);

        btn_Informativo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(portalInformativo.this,portalInformativo.class);
                startActivity(entrar);
            }
        });

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
