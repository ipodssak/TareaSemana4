package com.udemex.armando.mascotas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udemex.armando.mascotas.Contacto;
import com.udemex.armando.mascotas.ContactoAdaptador;
import com.udemex.armando.mascotas.R;

import java.util.ArrayList;

/**
 * Created by Armando on 29/01/2017.
 */
public class Recicler extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView listadecontactos;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentrecicler, container, false);

        listadecontactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadecontactos.setLayoutManager(llm);
        inicializarlistac();
        inicializarAdaptador();

        return v;
    }

    public void inicializarlistac(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.mascota3,"Kody","64675464353","PedroFernandez@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota5,"Pez","7243456754","Armando@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota2,"Bola de nieve","543232323","AnaKaren@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascotas_6,"los locos ","543232323","AnaKaren@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota7,"Rapido","7243456754","FernandoParedes@gmail.com"));

        contactos.add(new Contacto(R.drawable.mascota3,"Kody Junior","64675464353","PedroFernandez@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota5,"Pez Junior","7243456754","Armando@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota2,"Bola de nieve Junior","543232323","AnaKaren@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascotas_6,"los locos Junior","543232323","AnaKaren@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota7,"Rapido Junior","7243456754","FernandoParedes@gmail.com"));

    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,getActivity());
        listadecontactos.setAdapter(adaptador);
    }
}
