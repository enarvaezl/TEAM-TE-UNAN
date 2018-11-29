package com.example.enarvaez.basedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mRootReference;
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

        Clases =FirebaseDatabase.getInstance().getReference("Clases");

    txttema = (EditText)findViewById(R.id.txttema);
    spinarea= (Spinner) findViewById(R.id.spinarea);
    spinseccion= (Spinner) findViewById(R.id.spinseccion);
    btnregistrar= (Button) findViewById(R.id.btnregistrar);

    mButtonSubirDatosFirebase = findViewById(R.id.btnSubirDatos);
    mButtonSubirDatosFirebase.setOnClickListener(this);
    mEditTextDatoNombreUsuario = findViewById(R.id.etNombre);
    mEditTextDatoApellidoUsuario = findViewById(R.id.etApellido);
    mEditTextDatoTelefonoUsuario = findViewById(R.id.etTelefono);
    mEditTextDatoDireccionUsuario = findViewById(R.id.etDireccion);



mRootReference= FirebaseDatabase.getInstance().getReference();

//solicitarDatosFirebase();




        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

public void registrar()
{

    String sec=spinseccion.getSelectedItem().toString();
    String area=spinarea.getSelectedItem().toString();
    String tem=txttema.getText().toString();


            if(!TextUtils.isEmpty(tem))
            {
               String id=Clases.push().getKey();
               Clases leccion= new Clases(id,sec,area,tem);


                Clases.child("leccion").child(id).setValue(leccion);
                Toast.makeText( this,"ARCHIVO REGISTRADO",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText( this,"debe introducir un tema",Toast.LENGTH_LONG).show();

            }

}





}
