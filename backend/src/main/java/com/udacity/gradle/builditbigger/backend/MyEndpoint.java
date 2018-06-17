package com.udacity.gradle.builditbigger.backend;

import com.example.jokesprovider.JokesProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",

        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public MyJoke getJoke() {
        JokesProvider jokesProvider = new JokesProvider();

        MyJoke response = new MyJoke();
        response.setData(jokesProvider.getRandomJoke());

        return response;
    }

}
