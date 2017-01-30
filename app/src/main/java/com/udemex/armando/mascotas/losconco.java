package com.udemex.armando.mascotas;

/**
 * Created by Armando on 13/11/2016.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
public class losconco extends AppCompatActivity {


    ArrayList<Contacto> contactos;
    private RecyclerView listadecontactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  /*      setContentView(R.layout.activity_main);
        listadecontactos=(RecyclerView)findViewById(R.id.rvContactos);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadecontactos.setLayoutManager(llm);
        inicializarlistac();
        inicializarAdaptador();*/
    }


    public void inicializarlistac(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.mascota2,"Bola de nieve","543232323","AnaKaren@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota3,"Kody","64675464353","PedroFernandez@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota5,"Pez","7243456754","Armando@gmail.com"));

        contactos.add(new Contacto(R.drawable.mascotas_6,"los lokos","543232323","AnaKaren@gmail.com"));
        contactos.add(new Contacto(R.drawable.mascota7,"Rapido","7243456754","FernandoParedes@gmail.com"));

    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,this);
        listadecontactos.setAdapter(adaptador);
    }
}
