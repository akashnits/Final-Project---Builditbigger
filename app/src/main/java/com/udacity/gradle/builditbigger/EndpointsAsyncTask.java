package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.android.jokedisplaylib.JokeDisplay;
import com.example.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;
    private Context context;
    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null){
            MyApi.Builder builder= new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(),
                    null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService= builder.build();
        }
        context= params[0].first;
        String name= params[0].second;

        try{
            return myApiService.sayHi(name).execute().getData();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Intent intent= new Intent(context, JokeDisplay.class);
        intent.putExtra("joke", s);
        context.startActivity(intent);
    }
}
