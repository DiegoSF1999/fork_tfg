package com.example.salvamanteles;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {           // En este layout se hace el login

    EditText EmailEditText;
    EditText PasswordEditText;
    Button ForgottenButton;
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // descomenta esto cuando la api furule

   //     Retrofit retrofit = new Retrofit.Builder()
        //        .baseUrl("url base, terminada en api/")
       //         .addConverterFactory(GsonConverterFactory.create()).build();
     //   final Api api = retrofit.create(Api.class);


        EmailEditText = (EditText) findViewById(R.id.EmaileditText);
        PasswordEditText = (EditText) findViewById(R.id.PasswordeditText);
        ForgottenButton = (Button) findViewById(R.id.Forgotbutton);
        LoginButton = (Button) findViewById(R.id.Loginbutton);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                  startActivity(intent);

            }
        });

        ForgottenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotActivity.class);
                startActivity(intent);
            }
        });



    }


    void HacerLogin(){          // poner en el clicklistener de boton de login cuando furule la api

        Retrofit retrofit = new Retrofit.Builder()                              // quitar esta linea al implementarlo
                .baseUrl("url base, terminada en api/")                         // y esta
                .addConverterFactory(GsonConverterFactory.create()).build();    // esta tambien
        final Api api = retrofit.create(Api.class);                             // al igual que esta

        Call<Login> login = api.login(String.valueOf(EmailEditText.getText()), String.valueOf(PasswordEditText.getText()));     // esta no xd
        login.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                // AQUI EL SERVIDOR HA DEVUELTO 200
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                // AQUI HA DEVUELTO QUE LA AUTENTICACION FALLA O QUE NO SE HA PODIDO CONECTAR CON EL SERVIDOR
            }
        });

    }

}
