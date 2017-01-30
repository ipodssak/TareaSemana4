package com.udemex.armando.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Armando on 17/10/2016.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {
    Activity activity;
    ArrayList<Contacto> contactos;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos=contactos;
        this.activity=activity;
    }
    //infla el layout y lo pasa al view holdrer para que el obtenga cada elemento
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_comtacto,parent,false);
        return new ContactoViewHolder(v);
    }
    //asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder ContactoViewHolder, int position) {
        final Contacto contacto= contactos.get(position);
        ContactoViewHolder.imgFotoCV.setImageResource(contacto.getFoto());
        ContactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        ContactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());


        ContactoViewHolder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity ,contacto.getNombre(),Toast.LENGTH_LONG).show();;
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        ContactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Diste Like a "+contacto.getNombre(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene la lista

        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFotoCV= (ImageView)itemView.findViewById(R.id.imgfotocontacto);
            tvNombreCV=(TextView)itemView.findViewById(R.id.tvnombrecv);
            tvTelefonoCV=(TextView)itemView.findViewById(R.id.tvtelefonocv);
            btnLike=(ImageButton)itemView.findViewById(R.id.btnLike);
        }
    }



}
