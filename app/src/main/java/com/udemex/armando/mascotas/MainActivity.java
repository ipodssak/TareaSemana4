package com.udemex.armando.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.udemex.armando.mascotas.fragment.BlankFragment;
import com.udemex.armando.mascotas.fragment.Recicler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayoutfi;
    private ViewPager viewPagerhola;
    ArrayList<Contacto> contactos;
    private RecyclerView listadecontactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar= (Toolbar) findViewById(R.id.toolbar);
        tabLayoutfi=(TabLayout)findViewById(R.id.tablayout);
        viewPagerhola =(ViewPager)findViewById(R.id.viewpager);
        setUpViewPager();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if(id==R.id.opcion6){
            Intent i = new Intent(this,losconco.class);
           startActivity(i);
        }
        if(id==R.id.opcion5){
            Intent i = new Intent(this,ComentarioEnviar.class);
            startActivity(i);
        }
        if(id==R.id.opcion4){
            Intent i = new Intent(this,Acercade.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregandoFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Recicler());
        fragments.add(new BlankFragment());
        return fragments;
    }
    public void setUpViewPager(){
        viewPagerhola.setAdapter(new PageAdapter(getSupportFragmentManager(),agregandoFragments()));
        tabLayoutfi.setupWithViewPager(viewPagerhola);
        tabLayoutfi.getTabAt(0).setIcon(R.drawable.paseando_al_perro);
        tabLayoutfi.getTabAt(1).setIcon(R.drawable.huella_de_pata);


    }



}
