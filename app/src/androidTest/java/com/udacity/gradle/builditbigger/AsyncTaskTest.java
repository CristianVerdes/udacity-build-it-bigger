package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest implements Callback{
    
    @Test
    public void test_return_async_task() {
        JokesApiAsyncTask jokesApiAsyncTask = new JokesApiAsyncTask(this);
        jokesApiAsyncTask.execute();
    }

    // INTERFACE: Callback
    @Override
    public void publishData(String apiResponse) {
        Log.d("AsyncTaskTestApiResponse: ", apiResponse);
        assertThat(apiResponse, not(""));
    }
}
