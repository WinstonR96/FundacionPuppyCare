package co.com.worldsoft.puppycare.ui;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.worldsoft.puppycare.R;
import co.com.worldsoft.puppycare.provider.ContractParaGastos;
import co.com.worldsoft.puppycare.sync.SyncAdapter;
import co.com.worldsoft.puppycare.utils.Utilidades;

public class insertActivity extends AppCompatActivity {
    EditText nombre, ubicacion, descripcion, imagen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        setToolbar();

        nombre = (EditText) findViewById(R.id.nombrei);
        ubicacion = (EditText) findViewById(R.id.ubicacioni);
        descripcion = (EditText) findViewById(R.id.descripcioni);
        imagen = (EditText) findViewById(R.id.imageni);


    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void alClickearBoton(View v) {
        String nombreText = nombre.getText().toString();
        String ubicacionText = ubicacion.getText().toString();
        String descripcionText = descripcion.getText().toString();
        String imagenText = imagen.getText().toString();

        ContentValues values = new ContentValues();
        values.put(ContractParaGastos.Columnas.NOMBRE, nombreText);
        values.put(ContractParaGastos.Columnas.UBICACION, ubicacionText);
        values.put(ContractParaGastos.Columnas.DESCRIPCION, descripcionText);
        values.put(ContractParaGastos.Columnas.IMAGEN, imagenText);
        values.put(ContractParaGastos.Columnas.PENDIENTE_INSERCION, 1);

        getContentResolver().insert(ContractParaGastos.CONTENT_URI, values);
        SyncAdapter.sincronizarAhora(this, true);

        if (Utilidades.materialDesign())
            finishAfterTransition();
        else finish();
    }


}