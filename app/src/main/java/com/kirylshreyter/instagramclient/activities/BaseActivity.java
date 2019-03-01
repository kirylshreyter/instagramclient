package com.kirylshreyter.instagramclient.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kirylshreyter.instagramclient.activities.common.Tags;

public class BaseActivity extends AppCompatActivity {
    private int layoutId;

    BaseActivity(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tags.ON_CREATE.name(), "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
    }
}
