package com.example.enarvaez.basedatos;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import  com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {
    DatabaseReference datos;
    Button mButtonSubirDatosFirebase;
    EditText mEditTextDatoNombreUsuario,mEditTextDatoApellidoUsuario,
        mEditTextDatoTelefonoUsuario, mEditTextDatoDireccionUsuario;


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

            datos = FirebaseDatabase.getInstance().getReference();
            solictarDatosFirebase();
        }
            //Metodo que solicta los datos
            private void solictarDatosFirebase()
            {
                datos.child("Usuario").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {


                            datos.child("Usuario").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Clases user = snapshot.getValue(com.example.enarvaez.basedatos.Clases.class);
                                    String nombre = user.getNombre();
                                    String apellido = user.getApellido();
                                    int telefono = user.getTelefono();
                                    String direccion = user.getDireccion();

                                    Log.e("nombre de Usuario:" + "," + nombre);
                                    Log.e("Apellido :" + "," + apellido);
                                    Log.e("telefono :" + "," + telefono);
                                    Log.e("direccion :" + "," + direccion);
                                    Log.e("Datos: ", "" + snapshot.getValue());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }


            //metodo aue carga los datos

            private void CargarDatos (String nombre, String apellido, int telefono, String direccion){

                Map<String,Object> datosUsuarios= new HashMap<>();
                datosUsuarios.put("nombre",nombre);
                datosUsuarios.put("apellido", apellido);
                datosUsuarios.put("telefono",telefono);
                datosUsuarios.put("direccion",direccion);
                datos.child("Usuario").push().setValue(datosUsuarios);

            }







        }







