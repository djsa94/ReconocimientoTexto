package com.example.daniel.expo.listaTweets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.daniel.expo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ListaTweets extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tweets);
        Gson gson = new Gson();
        ArrayList<String> lista ;
        TypeToken<ArrayList<String>> token = new TypeToken<ArrayList<String>>() {};
        lista = gson.fromJson(getIntent().getExtras().getString("estados"), token.getType());
        AdaptadorTweets adapter = new AdaptadorTweets(this, lista);
        ListView list = (ListView) findViewById(R.id.lista_tweets_list_view);
        list.setAdapter(adapter);



        //Intent intent = new Intent(this, FacebookLoginActivity.class);
       // startActivity(intent);
    }
}
