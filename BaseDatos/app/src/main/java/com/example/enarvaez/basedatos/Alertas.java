package com.example.enarvaez.basedatos;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class Alertas extends AppCompatActivity {

    private ImageButton btn_Directorio;
    private ImageButton btn_Servicios;
    private ImageButton btn_Alertas;
    private ImageButton btn_Informativo;

    private CheckBox checkBox1,checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertas);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        btn_Directorio= (ImageButton)findViewById(R.id.imageBDirectorio3);

        btn_Directorio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(Alertas.this,DirectorioCentroMedico.class);
                startActivity(entrar);
            }
        });

        btn_Servicios= (ImageButton)findViewById(R.id.imageBServicio3);

        btn_Servicios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(Alertas.this,ServiciosdeConsulta.class);
                startActivity(entrar);
            }
        });

        btn_Alertas= (ImageButton)findViewById(R.id.imageBAlerta3);

        btn_Alertas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(Alertas.this,Alertas.class);
                startActivity(entrar);
            }
        });
        btn_Informativo= (ImageButton)findViewById(R.id.imageBInformativo3);

        btn_Informativo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent entrar= new Intent(Alertas.this,portalInformativo.class);
                startActivity(entrar);
            }
        });
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( checkBox1.isChecked()== true){
                    checkBox1.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkBox2=(CheckBox)findViewById(R.id.checkBox2);

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( checkBox2.isChecked()== true){
                    checkBox2.setVisibility(View.INVISIBLE);
                }
            }
        });



        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
