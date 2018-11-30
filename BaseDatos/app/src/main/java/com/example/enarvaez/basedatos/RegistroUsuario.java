package com.example.enarvaez.basedatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

    public class RegistroUsuario extends AppCompatActivity implements  View.OnClickListener {

        DatabaseReference datos;
        ImageButton dButtonSubirDatosFirebase;
        EditText dEditTextDatoNombreUsuario,
                dEditTextDatoCorreoUsuario,
                dEditTextDatobarrioUsuario,
                dEditTextDatoMunicipioUsuario,
                dEditTextDatoDepaUsuario,
                dEditTextDatocontraUsuario,
                dEditTextDatorcontraUsuario;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_registro_usuario);

            dButtonSubirDatosFirebase = findViewById(R.id.btnSubirDatos);
            dButtonSubirDatosFirebase.setOnClickListener(this);
            dEditTextDatoNombreUsuario = findViewById(R.id.etNombre);
            dEditTextDatoCorreoUsuario=findViewById(R.id.etCorreo);
            dEditTextDatobarrioUsuario=findViewById(R.id.etBarrio);
            dEditTextDatoMunicipioUsuario = findViewById(R.id.etMunicipio);
            dEditTextDatoDepaUsuario=findViewById(R.id.etDepartamento);
            dEditTextDatocontraUsuario =findViewById(R.id.etcontras);
            dEditTextDatorcontraUsuario=findViewById(R.id.etrep_contra);


            datos = FirebaseDatabase.getInstance().getReference();
            solictarDatosFirebase();
        }
        //Metodo que solicta los datos
        private void solictarDatosFirebase()
        {
            datos.child("Usuario").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange( DataSnapshot dataSnapshot) {

                    for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {


                        datos.child("Usuario").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Clases user = snapshot.getValue(com.example.enarvaez.basedatos.Clases.class);
                                String nombre = user.getNombre();
                                String correo = user.getCorreo();
                                String barrio=user.getBarrio();
                                String municipio=user.getMunicipio();
                                String departamento=user.getDepartamento();
                                String contrasena=user.getContrasena();
                                String Rcontrasena=user.getRcontrasena();


                                //muestra datos por consola

                                Log.e("nombre de Usuario:" ," "+ nombre);
                                Log.e("correo :"  ," "+ correo);
                                Log.e("barrio :" ," "+ barrio);
                                Log.e("municipio :"  ," "+ municipio);
                                Log.e("departamento :"  ," "+ departamento);
                                Log.e("contraseña :"  ," "+ contrasena);
                                Log.e("Rcontraseña :"  ," "+ Rcontrasena);

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


        //metodo que carga los datos

        private void CargarDatos (String nombre, String correo, String barrio,String municipio,String departamento, String contra, String rcontra){

            Map<String,Object> datosUsuarios= new HashMap<>();
            datosUsuarios.put("nombre",nombre);
            datosUsuarios.put("correo", correo);
            datosUsuarios.put("barrio",barrio);
            datosUsuarios.put("municipio",municipio);
            datosUsuarios.put("departamento",departamento);
            datosUsuarios.put("contraseña",contra);
            datosUsuarios.put("Repetir contraseña",rcontra);
            datos.child("Usuario").push().setValue(datosUsuarios);

        }


        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btnSubirDatos:


                    String nombre=dEditTextDatoNombreUsuario.getText().toString();
                    String correo=dEditTextDatoCorreoUsuario.getText().toString();
                    String barrio= dEditTextDatobarrioUsuario.getText().toString();
                    String municipio= dEditTextDatoMunicipioUsuario .getText().toString();
                    String departamento= dEditTextDatoDepaUsuario.getText().toString();
                    String contraseña= dEditTextDatorcontraUsuario.getText().toString();
                    String Rcontraseña=dEditTextDatorcontraUsuario.getText().toString();

                    CargarDatos(nombre,correo,barrio,municipio,departamento,contraseña,Rcontraseña);

                    Intent irlogin= new Intent(RegistroUsuario.this,IniciarSesion.class);
                    startActivity(irlogin);


            }

        }
    }

