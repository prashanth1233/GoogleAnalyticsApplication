package com.example.prasanth.googleanalyticsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.prasanth.googleanalyticsapplication.activity.AnalyticsApplication;
import com.example.prasanth.googleanalyticsapplication.activity.VideoViewCountAcitivity;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Tracker tracker;
    private String screenName = "Main Activity";
    private Button nextActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextActivityButton = (Button) findViewById(R.id.nextAcitivityButton);
        AnalyticsApplication analyticsApplication = (AnalyticsApplication) getApplication();
        tracker = analyticsApplication.getDefaultTracker();

        nextActivityButton.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ScreenName", "Setting Screen Name:" + screenName);
        tracker.setScreenName(screenName);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
        GoogleAnalytics.getInstance(this).dispatchLocalHits();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextAcitivityButton:
                Intent intent = new Intent(this, VideoViewCountAcitivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
