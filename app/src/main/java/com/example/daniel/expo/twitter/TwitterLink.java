package com.example.daniel.expo.twitter;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.daniel.expo.listaTweets.ListaTweets;
import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterLink {
    List<twitter4j.Status> lista;
    Activity activity;
    Gson gson;
    public void getTweets(String user, Activity activity){
        this.activity = activity;
        new llamarTwitter().execute(user);
        gson = new Gson();

    }

    class llamarTwitter extends AsyncTask<String, Void, Void> {

        private Exception exception;

        protected Void doInBackground(String... entrada) {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setOAuthConsumerKey("rQjdiwu1UMBKfVK0HWhHGCnL2")
                    .setOAuthConsumerSecret(
                            "jqChb4t3H823mC64iQ1lWTMURbOAUOgnVsMc7Tf3Eeo9zt8gN2")
                    .setOAuthAccessToken(
                            "2626724559-MJuxlYdLNT4NeMFfiebMlSyIl9WlasI9slUtxGj")
                    .setOAuthAccessTokenSecret(
                            "zYaj5mLoilt27ZtinsDsrTIv5xK0yPZkQYk2XgT0gWc2r");
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            try {
                List<twitter4j.Status> statuses;
                String user;
                user = entrada[0];
                lista = twitter.getUserTimeline(user);
                ArrayList<String> estados = new ArrayList<String>();

                Log.i("Status Count", lista.size() + " Feeds");
                for(int i = 0; i<lista.size(); i++){
                    estados.add(lista.get(i).getText());
                }
                Intent intent = new Intent(activity, ListaTweets.class);
                intent.putExtra("estados",gson.toJson(estados));
                activity.startActivity(intent);

            } catch (TwitterException te) {
                te.printStackTrace();
            }
            return null;
        }




    }
}
