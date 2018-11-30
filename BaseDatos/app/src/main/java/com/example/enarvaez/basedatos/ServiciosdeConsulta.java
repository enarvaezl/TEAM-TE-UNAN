package com.example.enarvaez.basedatos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ServiciosdeConsulta extends AppCompatActivity {
    DatabaseReference datos;

    Spinner Hospital;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviciosde_consulta);

        RegistroUsuario reg=new RegistroUsuario();
        Hospital=findViewById(R.id.spinnerhospital);
        reg.solictarDatosFirebase();
        Hospital.getSelectedItem().toString();



    }





}
