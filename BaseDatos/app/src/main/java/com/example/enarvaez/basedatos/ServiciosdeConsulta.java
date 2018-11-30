package com.example.enarvaez.basedatos;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class ServiciosdeConsulta extends AppCompatActivity {

    private ImageView imageView;

    private ImageButton btn_Directorio;
    private ImageButton btn_Servicios;
    private ImageButton btn_Alertas;
    private ImageButton btn_Informativo;

    private Spinner spinner1;
    private ImageView imageBDato;
    private EditText editTextTipo;


    private ImageButton imageBBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviciosde_consulta);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        btn_Directorio= (ImageButton)findViewById(R.id.imageBDirectorio4);

        btn_Directorio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ServiciosdeConsulta.this,DirectorioCentroMedico.class);
                startActivity(entrar);
            }
        });

        btn_Servicios= (ImageButton)findViewById(R.id.imageBServicio4);

        btn_Servicios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ServiciosdeConsulta.this,ServiciosdeConsulta.class);
                startActivity(entrar);
            }
        });

        btn_Alertas= (ImageButton)findViewById(R.id.imageBAlerta4);

        btn_Alertas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ServiciosdeConsulta.this,Alertas.class);
                startActivity(entrar);
            }
        });

        btn_Informativo= (ImageButton)findViewById(R.id.imageBInformativo4);

        btn_Informativo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(ServiciosdeConsulta.this,portalInformativo.class);
                startActivity(entrar);
            }
        });

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        spinner1=(Spinner) findViewById(R.id.spinner);

        editTextTipo=(EditText)findViewById(R.id.editText11);

        imageBDato=(ImageView) findViewById(R.id.imageViewservicio);
        imageBDato.setVisibility(View.INVISIBLE);

        imageBBuscar=(ImageButton) findViewById(R.id.butonbuscar);

        imageBBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imageBDato.setVisibility(View.VISIBLE);
            }
        });

    }
}

