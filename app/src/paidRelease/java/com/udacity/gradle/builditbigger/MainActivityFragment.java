package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment implements Callback{

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        addJokeButtonListener(rootView);

        return rootView;
    }

    public void addJokeButtonListener(View rootView) {
        Button showJokes = rootView.findViewById(R.id.bt_show_joke);
        showJokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JokesApiAsyncTask jokesApiAsyncTask = new JokesApiAsyncTask(MainActivityFragment.this);
                jokesApiAsyncTask.execute();
            }
        });
    }

    // INTERFACE: Callback
    @Override
    public void publishData(String apiResponse) {
        // Start Display Activity when Api call is finished
        DisplayJokeActivity.start(getActivity(), apiResponse);
    }
}
