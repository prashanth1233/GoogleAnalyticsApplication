package com.example.prasanth.googleanalyticsapplication.activity;

import android.app.Application;

import com.example.prasanth.googleanalyticsapplication.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Prasanth on 11/13/2017.
 */



/**
 * This is a subclass of {@link Application} used to provide shared objects for this app, such as
 * the {@link Tracker}.
 */
public class AnalyticsApplication extends Application {
    private GoogleAnalytics googleAnalytics;
    private Tracker tracker;

    @Override
    public void onCreate() {
        super.onCreate();
        googleAnalytics = GoogleAnalytics.getInstance(this);
    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            tracker = googleAnalytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }
}
