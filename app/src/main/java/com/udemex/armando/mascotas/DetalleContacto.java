package com.udemex.armando.mascotas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {


    private TextView tvnombre;
    private TextView tvtel;
    private TextView tvemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle paramentro = getIntent().getExtras();
        String nombre = paramentro.getString("nombre");
        String telefono = paramentro.getString(getResources().getString(R.string.ptelefono));
        String email = paramentro.getString(getResources().getString(R.string.pemail));

        tvnombre = (TextView) findViewById(R.id.tvnombre);
        tvtel = (TextView) findViewById(R.id.tvtel);
        tvemail = (TextView) findViewById(R.id.tvtemail);


        tvnombre.setText(nombre);
        tvtel.setText(telefono);
        tvemail.setText(email);

    }

    public void llamar(View view) {

        String Telefono = tvtel.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Telefono)));

    }

    public  void  email (View view){

        String elemail=tvemail.getText().toString();
        Intent email= new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_EMAIL,elemail);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email,"Email"));
    }

}

