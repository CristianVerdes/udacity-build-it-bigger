package com.example.jokesprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokesProvider {

    public String getRandomJoke() {
        List<String> jokes = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            jokes.add(" Your lucky number is: " + String.valueOf(i) + " \n (for now... If you press again it might be another :D )") ;
        }

        return jokes.get(new Random().nextInt(10));
    }
}
