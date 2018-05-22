package com.example.daniel.expo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daniel.expo.analizadorTono.AnalizadorTono;
import com.example.daniel.expo.twitter.TwitterLink;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity actividad = this;
        //AnalizadorTono tono = new AnalizadorTono("2017-09-21", "8cf905ba-109f-461d-be81-09e9874a1d25", "8QnBFbkDNQGN");
        //tono.analizar("This is a very nice car ");

        final EditText entradaFrase = (EditText) findViewById(R.id.main_activity_edit_text);
        final TextView resultado = (TextView) findViewById(R.id.main_activity_text_resultados);

        final EditText user = (EditText) findViewById(R.id.main_activity_username);

        Button analizarFrase = (Button) findViewById(R.id.main_activity_edit_button_analizar);
        Button analizarTweets = (Button) findViewById(R.id.main_activity_boton_tweets);

        analizarFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalizadorTono analizador = new AnalizadorTono("2017-09-21", "8cf905ba-109f-461d-be81-09e9874a1d25", "8QnBFbkDNQGN");
                analizador.analizar(entradaFrase.getText().toString(), resultado);
            }
        });

        analizarTweets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TwitterLink link = new TwitterLink();
                link.getTweets(user.getText().toString(), actividad);
            }
        });


    }
}
