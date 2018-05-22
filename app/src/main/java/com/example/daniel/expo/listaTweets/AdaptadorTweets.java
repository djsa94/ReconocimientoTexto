package com.example.daniel.expo.listaTweets;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.expo.R;
import com.example.daniel.expo.analizadorTono.AnalizadorTono;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AdaptadorTweets extends ArrayAdapter<String> {

    Context contexto;
    Gson gson = new Gson();

    public AdaptadorTweets(Context context, ArrayList<String>  tweets) {
        super(context, 0, tweets);
        this.contexto = context;
        Log.e("Probando lista", String.valueOf(tweets.size()));

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tweet_tweet);
        textView.setText(getItem(position));
        TextView textView2 = (TextView) convertView.findViewById(R.id.tweet_analisis);
        AnalizadorTono analizador = new AnalizadorTono("2017-09-21", "8cf905ba-109f-461d-be81-09e9874a1d25", "8QnBFbkDNQGN");
        analizador.analizar(getItem(position), textView2);









        return convertView;
    }
}
