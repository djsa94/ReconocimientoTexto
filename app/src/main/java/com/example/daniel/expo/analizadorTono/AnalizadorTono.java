package com.example.daniel.expo.analizadorTono;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;

public class AnalizadorTono {
    ToneAnalyzer toneAnalyzer;
    TextView tv;

    public AnalizadorTono(String version, String user, String pass) {
        toneAnalyzer = new ToneAnalyzer(version);
        toneAnalyzer.setUsernameAndPassword(user, pass);

    }

    public void analizar(String entrada, TextView tv) {
        this.tv = tv;
        new llamarAPI().execute(entrada);
    }

    class llamarAPI extends AsyncTask<String, Void, String> {

        private Exception exception;

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        protected String doInBackground(String... entrada) {
            try {
                ToneOptions toneOptions = new ToneOptions.Builder().text(entrada[0]).build();
                ToneAnalysis tone = toneAnalyzer.tone(toneOptions).execute();
                tv.setText(tone.getDocumentTone().getTones().get(0).getToneName());
                Log.e("Entrada", entrada[0]);
                Log.e("Respuesta", tone.getDocumentTone().getTones().toString());


            } catch (Exception e) {


            } finally {

            }
            return "";
        }


    }
}
