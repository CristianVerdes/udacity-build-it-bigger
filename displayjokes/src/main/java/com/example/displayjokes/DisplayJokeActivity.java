package com.example.displayjokes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.TextView;

/**
 * Created by cristian.verdes on 27.03.2018.
 */

public class DisplayJokeActivity extends AppCompatActivity {
    private static final String KEY_JOKE = "key_joke";

    public static void start(Context context, String joke) {
        Intent starter = new Intent(context, DisplayJokeActivity.class);
        starter.putExtra(KEY_JOKE, joke);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        // Get joke from intent
        String joke = getIntent().getStringExtra(KEY_JOKE);

        TextView jokeTextView = findViewById(R.id.tv_joke);

        jokeTextView.setText(joke);
    }
}
