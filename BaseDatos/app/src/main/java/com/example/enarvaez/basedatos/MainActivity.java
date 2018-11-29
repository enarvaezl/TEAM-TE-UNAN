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
    public DatabaseReference data;


    EditText txtTema;
    Spinner spinAreas, spinSecciones;
    Button btnregistrar;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data =FirebaseDatabase.getInstance().getReference("data");

        txtTema = findViewById(R.id.txttema);
        spinAreas= findViewById(R.id.spinarea);
        spinSecciones= findViewById(R.id.spinseccion);
        btnregistrar= findViewById(R.id.btnregistrar);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

public void registrar()
{

    String sec=spinSecciones.getSelectedItem().toString();
    String area=spinAreas.getSelectedItem().toString();
    String tem=txtTema.getText().toString();


            if(!TextUtils.isEmpty(tem))
            {
                String id=data.push().getKey();
                clases l= new clases(id,sec,area,tem);


                data.child("Lecciones").child(id).setValue(l);
                Toast.makeText( this,"Clase",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText( this,"debe introducir un tema",Toast.LENGTH_LONG).show();

            }

}

}
