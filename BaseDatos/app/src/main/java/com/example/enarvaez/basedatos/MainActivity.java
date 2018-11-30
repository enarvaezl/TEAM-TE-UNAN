package com.example.enarvaez.basedatos;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import  com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference datos;
    Button dButtonSubirDatosFirebase;
    EditText dEditTextDatoNombreUsuario,dEditTextDatoApellidoUsuario,
        dEditTextDatoTelefonoUsuario, dEditTextDatoDireccionUsuario;


        @Override
            protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            dButtonSubirDatosFirebase = findViewById(R.id.btnSubirDatos);
            dButtonSubirDatosFirebase.setOnClickListener(this);
            dEditTextDatoNombreUsuario = findViewById(R.id.etNombre);
            dEditTextDatoApellidoUsuario = findViewById(R.id.etApellido);
            dEditTextDatoTelefonoUsuario = findViewById(R.id.etTelefono);
            dEditTextDatoDireccionUsuario = findViewById(R.id.etDireccion);

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

                                    /*Log.e("nombre de Usuario:" + "," + nombre);
                                    Log.e("Apellido :" + "," + apellido);
                                    Log.e("telefono :" + "," + telefono);
                                    Log.e("direccion :" + "," + direccion);
                                    Log.e("Datos: ", "" + snapshot.getValue());

                                    */
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


    @Override
    public void onClick(View v) {

            switch (v.getId()){
                case R.id.btnSubirDatos:


                    String nombre=dEditTextDatoNombreUsuario.getText().toString();
                    String apellido=dEditTextDatoApellidoUsuario.getText().toString();
                    int telefono=Integer.parseInt(dEditTextDatoTelefonoUsuario.getText().toString());
                    String direccion=dEditTextDatoDireccionUsuario.getText().toString();
                    CargarDatos(nombre,apellido,telefono,direccion);

            }

    }
}







