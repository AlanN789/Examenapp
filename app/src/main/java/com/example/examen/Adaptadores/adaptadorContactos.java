package com.example.examen.Adaptadores;


import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.examen.MainActivity;
import com.example.examen.Modelos.Accion;
import com.example.examen.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen.Modelos.Contacto;

import java.util.List;

public class adaptadorContactos extends RecyclerView.Adapter<adaptadorContactos.ViewHolder> {
    private List<Accion> Lista;

    public adaptadorContactos(List<Accion> lista) {
        Lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Accion c = Lista.get(position);
        holder.bind(c);
    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Nombre;
        TextView Acciones;
        Contacto cont;
        Accion acc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = itemView.findViewById(R.id.txt1);
            Acciones = itemView.findViewById(R.id.txt2);
            itemView.setOnClickListener(this);
        }
        public void bind (Accion c){
            Nombre.setText(c.getAccion());
            Acciones.setText(c.getDescripcion());
            acc=c;
        }

        @Override
        public void onClick(View view) {

            switch (acc.getId()){
                case 1:
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8713788377"));
                    view.getContext().startActivity(i);
                    break;
                case 2:
                    Intent e = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    view.getContext().startActivity(e);
                    break;
                case 3:
                    Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps"));
                    view.getContext().startActivity(a);
                    break;
                case 4:
                    Intent d = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8713788377"));
                    view.getContext().startActivity(d);
                case 5:

            }


        }
    }

}
