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


public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;
    private Context mContext;

    public EndpointsAsyncTask(Context context) {
        this.mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {
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


        try{
            return myApiService.getJoke().execute().getData();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Intent intent= new Intent(mContext, JokeDisplay.class);
        intent.putExtra("joke", s);
        mContext.startActivity(intent);
    }
}
