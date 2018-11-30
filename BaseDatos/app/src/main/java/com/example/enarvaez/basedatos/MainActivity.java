package com.example.enarvaez.basedatos;

import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import  com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference datos;
    Button mButtonSubirDatosFirebase;
    EditText mEditTextDatoNombreUsuario,mEditTextDatoApellidoUsuario,
        mEditTextDatoTelefonoUsuario, mEditTextDatoDireccionUsuario;


       DatabaseReference Clases;

        EditText txttema;
        Spinner spinarea, spinseccion;
        Button btnregistrar;

        @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_main);

            mButtonSubirDatosFirebase = findViewById(R.id.btnSubirDatos);
            mButtonSubirDatosFirebase.setOnClickListener(this);
            mEditTextDatoNombreUsuario = findViewById(R.id.etNombre);
            mEditTextDatoApellidoUsuario = findViewById(R.id.etApellido);
            mEditTextDatoTelefonoUsuario = findViewById(R.id.etTelefono);
            mEditTextDatoDireccionUsuario = findViewById(R.id.etDireccion);

            datos= FirebaseDatabase.getInstance().getReference();
        //


           private void solictarDatosFirebase()

        {
          datos.child("Usuario").addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                  for (final DataSnapshot snapshot: dataSnapshot.getChildren()) {


                      datos.child("Usuario").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                          @Override
                          public void onDataChange(DataSnapshot dataSnapshot) {
                              Clases user = snapshot.getValue(com.example.enarvaez.basedatos.Clases.class);
                              String nombre= user.getNombre();
                              String apellido= user.getApellido();
                              int telefono=user.getTelefono();
                              String direccion=user.getDireccion();

                              long.e("nombre de Usuario");
                          }

                          @Override
                          public void onCancelled(@NonNull DatabaseError databaseError) {

                          }
                      });


                  }
              }

              @Override
              public void onCancelled(@NonNull DatabaseError databaseError) {

              }
          });

        }








    }
