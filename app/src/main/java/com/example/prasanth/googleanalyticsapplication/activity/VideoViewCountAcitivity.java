package com.example.prasanth.googleanalyticsapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.prasanth.googleanalyticsapplication.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.Map;

public class VideoViewCountAcitivity extends AppCompatActivity implements View.OnClickListener {

    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_count_acitivity);
        AnalyticsApplication analyticsApplication = (AnalyticsApplication) getApplication();
        tracker = analyticsApplication.getDefaultTracker();

        Button playVideoBtn = (Button) findViewById(R.id.playvideoBtn);
        playVideoBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tracker.setScreenName("VideoCountScreen");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playvideoBtn:

                /*To count button clicks using google analytics*/
                tracker.send(new HitBuilders.EventBuilder()
                        .setCategory("watch video")
                        .setAction("Watching")
                        .setLabel("Hello")
                        .build());
                break;
            default:
                break;
        }
    }


}
