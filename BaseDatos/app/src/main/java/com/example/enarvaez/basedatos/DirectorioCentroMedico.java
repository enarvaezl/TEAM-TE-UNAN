package com.example.enarvaez.basedatos;



import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DirectorioCentroMedico extends AppCompatActivity {

    private ImageButton btn_Directorio;
    private ImageButton btn_Servicios;
    private ImageButton btn_Alertas;
    private ImageButton btn_Informativo;

    private ImageButton imageBBuscar;

    private ImageView imageBDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directorio_centro_medico);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        btn_Directorio= (ImageButton)findViewById(R.id.imageBDirectorio2);

        btn_Directorio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(DirectorioCentroMedico.this,DirectorioCentroMedico.class);
                startActivity(entrar);
            }
        });

        btn_Servicios= (ImageButton)findViewById(R.id.imageBServicio2);

        btn_Servicios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(DirectorioCentroMedico.this,ServiciosdeConsulta.class);
                startActivity(entrar);
            }
        });

        btn_Alertas= (ImageButton)findViewById(R.id.imageBAlerta2);

        btn_Alertas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(DirectorioCentroMedico.this,Alertas.class);
                startActivity(entrar);
            }
        });

        btn_Informativo= (ImageButton)findViewById(R.id.imageBInformativo2);

        btn_Informativo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(DirectorioCentroMedico.this,portalInformativo.class);
                startActivity(entrar);
            }
        });

        /*imageBDato=(ImageView) findViewById(R.id.imageViewsalud);
        imageBBuscar=(ImageButton) findViewById(R.id.imageBBuscar);
        imageBDato.setVisibility(View.INVISIBLE);*/

        /*imageBBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imageBDato.setVisibility(View.VISIBLE);
            }
        });*/


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}