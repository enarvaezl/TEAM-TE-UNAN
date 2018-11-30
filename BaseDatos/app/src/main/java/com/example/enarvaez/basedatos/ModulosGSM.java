package com.example.enarvaez.basedatos;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class ModulosGSM extends AppCompatActivity {
    private ImageButton btn_Directorio;
    private ImageButton btn_Servicios;
    private ImageButton btn_Alertas;
    private ImageButton btn_Informativo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos_gsm);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        btn_Directorio= (ImageButton)findViewById(R.id.imageBDirectorio);

        btn_Directorio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ModulosGSM.this,DirectorioCentroMedico.class);
                startActivity(entrar);
            }
        });

        btn_Servicios= (ImageButton)findViewById(R.id.imageBServicio);

        btn_Servicios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ModulosGSM.this,ServiciosdeConsulta.class);
                startActivity(entrar);
            }
        });

        btn_Alertas= (ImageButton)findViewById(R.id.imageBAlerta);

        btn_Alertas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ModulosGSM.this,Alertas.class);
                startActivity(entrar);
            }
        });

        btn_Informativo= (ImageButton)findViewById(R.id.imageBInformativo);

        btn_Informativo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ModulosGSM.this,portalInformativo.class);
                startActivity(entrar);
            }
        });

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}