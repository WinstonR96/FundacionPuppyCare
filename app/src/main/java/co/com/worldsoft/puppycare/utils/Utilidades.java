package co.com.worldsoft.puppycare.utils;

import android.database.Cursor;
import android.os.Build;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import co.com.worldsoft.puppycare.provider.ContractParaGastos;

public class Utilidades {
    // Indices para las columnas indicadas en la proyección
    public static final int COLUMNA_ID = 0;
    public static final int COLUMNA_ID_REMOTA = 1;
    public static final int COLUMNA_NOMBRE = 2;
    public static final int COLUMNA_UBICACION = 3;
    public static final int COLUMNA_DESCRIPCION = 4;
    public static final int COLUMNA_IMAGEN = 5;

    /**
     * Determina si la aplicación corre en versiones superiores o iguales
     * a Android LOLLIPOP
     *
     * @return booleano de confirmación
     */
    public static boolean materialDesign() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * Copia los datos de un gasto almacenados en un cursor hacia un
     * JSONObject
     *
     * @param c cursor
     * @return objeto jason
     */
    public static JSONObject deCursorAJSONObject(Cursor c) {
        JSONObject jObject = new JSONObject();
        String nombre;
        String ubicacion;
        String descripcion;
        String imagen;

        nombre = c.getString(COLUMNA_NOMBRE);
        ubicacion = c.getString(COLUMNA_UBICACION);
        descripcion = c.getString(COLUMNA_DESCRIPCION);
        imagen = c.getString(COLUMNA_IMAGEN);

        try {
            jObject.put(ContractParaGastos.Columnas.NOMBRE, nombre);
            jObject.put(ContractParaGastos.Columnas.UBICACION, ubicacion);
            jObject.put(ContractParaGastos.Columnas.DESCRIPCION, descripcion);
            jObject.put(ContractParaGastos.Columnas.IMAGEN, imagen);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("Cursor a JSONObject", String.valueOf(jObject));

        return jObject;
    }
}
