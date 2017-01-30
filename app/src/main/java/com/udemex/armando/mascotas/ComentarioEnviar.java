package com.udemex.armando.mascotas;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComentarioEnviar extends AppCompatActivity implements View.OnClickListener {
    //Declaring EditText
    private TextInputEditText nombre = null;
    private TextInputEditText correo= null;
    private TextInputEditText comentario= null;

    private Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_comentario_enviar);
        nombre =(TextInputEditText) findViewById(R.id.nombre);
        correo =(TextInputEditText) findViewById(R.id.correo);
        comentario =(TextInputEditText) findViewById(R.id.mensaje);
        enviar = (Button) findViewById(R.id.enviar);
        //Adding click listener
        enviar.setOnClickListener(this);

    }


    private void sendEmail() {
        //Getting content for email
        String nom = nombre.getText().toString().trim();
        String cor = correo.getText().toString().trim();
        String com= comentario.getText().toString().trim();

        String Mensaje =cor+" "+com;

        //Creating SendMail object
        SendMail sm = new SendMail(this,cor,nom,Mensaje);

        //Executing sendmail to send email
        sm.execute();
    }
    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
