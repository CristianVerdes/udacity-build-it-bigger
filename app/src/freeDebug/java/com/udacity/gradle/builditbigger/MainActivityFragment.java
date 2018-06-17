package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.displayjokes.DisplayJokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment implements Callback {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        addJokeButtonListener(rootView);

        addGoogleAd(rootView);

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

    public void addGoogleAd(View rootView) {
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }


    // INTERFACE: Callback
    @Override
    public void publishData(String apiResponse) {
        // Start Display Activity when Api call is finished
        DisplayJokeActivity.start(getActivity(), apiResponse);
    }

}
