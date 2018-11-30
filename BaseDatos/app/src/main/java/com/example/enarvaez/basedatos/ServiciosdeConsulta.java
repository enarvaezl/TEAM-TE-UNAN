package com.example.enarvaez.basedatos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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


        Hospital=findViewById(R.id.spinnerhospital);
        datos=FirebaseDatabase.getInstance().getReference(getString(R.string.project_id));


        datos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayAdapter<String> adaptador;
                ArrayList<String> lista = new ArrayList<String>();

                for (final DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    Clases clase= dataSnapshot1.getValue(Clases.class);
                    String n=clase.getNombre();
                    lista.add(n);


                }


                adaptador=new ArrayAdapter<String>(activitymain2.this.);
                lista.setAdpater(adaptador);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })

    }





}
