package co.com.worldsoft.puppycare.ui;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import co.com.worldsoft.puppycare.R;


/**
 * Adaptador del recycler view
 */
public class AdaptadorDeGastos extends RecyclerView.Adapter<AdaptadorDeGastos.ViewHolder> {
    private Cursor cursor;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView Viewnombre;
        public TextView Viewubicacion;
        public TextView Viewdescripcion;
        public ImageView Viewimagen;


        public ViewHolder(View v) {
            super(v);
            Viewnombre = (TextView) v.findViewById(R.id.nombre);
            Viewubicacion = (TextView) v.findViewById(R.id.ubicacion);
            Viewdescripcion = (TextView) v.findViewById(R.id.descripcion);
            Viewimagen = (ImageView) v.findViewById(R.id.foto);

        }
    }

    public AdaptadorDeGastos(Context context) {
        this.context= context;

    }

    @Override
    public int getItemCount() {
        if (cursor!=null)
            return cursor.getCount();
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        cursor.moveToPosition(i);

        String nombre;
        String ubicacion;
        String descripcion;
        String imagen;

        nombre = cursor.getString(1);
        ubicacion = cursor.getString(2);
        descripcion = cursor.getString(3);
        imagen = cursor.getString(4);




        // Asignación UI

        viewHolder.Viewnombre.setText(nombre);


        viewHolder.Viewubicacion.setText(ubicacion);


        viewHolder.Viewdescripcion.setText(descripcion);


        Glide.with(context).load(imagen).centerCrop().into(viewHolder.Viewimagen);
    }

    public void swapCursor(Cursor newCursor) {
        cursor = newCursor;
        notifyDataSetChanged();
    }

    public Cursor getCursor() {
        return cursor;
    }
}