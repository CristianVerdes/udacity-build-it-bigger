package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokesApiAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Callback callback;

    public JokesApiAsyncTask(Callback callback) {
        // Set interface which will be called later
        this.callback = callback;

        // Create MyApi Instance
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                        request.setDisableGZipContent(true);
                    }
                });
        myApiService = builder.build();
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            // Execute call to API and return value
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            // If Api sends error we return it
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        //Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
        callback.publishData(response);
    }
}
